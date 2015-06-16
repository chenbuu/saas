/**
 * 陈涛开发
 * PlaceHolder组件
 * $(input).placeholder({
 *   word:     // @string 提示文本
 *   color:    // @string 文本颜色
 *   evtType:  // @string focus|keydown 触发placeholder的事件类型
 * });
 *
 * NOTE：
 *   evtType默认是focus，即鼠标点击到输入域时默认文本消失，keydown则模拟HTML5 placeholder属性在Firefox/Chrome里的特征，光标定位到输入域后键盘输入时默认文本才消失。
 *   此外，对于HTML5 placeholder属性，IE10+和Firefox/Chrome/Safari的表现形式也不一致，因此内部实现不采用原生placeholder属性
 */
$.fn.placeholder = function(option, callback) {
    var settings = $.extend({
        word: '',
        color: '#999',
        evtType: 'focus',
        zIndex: 20,
        diffPaddingLeft: 3
    }, option);
 
    function bootstrap($that) {
        // some alias
        var word    = settings.word;
        var color   = settings.color;
        var evtType = settings.evtType;
        var zIndex  = settings.zIndex;
        var diffPaddingLeft = settings.diffPaddingLeft;
 
        // default css
        var width       = $that.outerWidth();
        var height      = $that.outerHeight();
        var fontSize    = $that.css('font-size');
        var fontFamily  = $that.css('font-family');
        var paddingLeft = $that.css('padding-left');
 
        // process
        paddingLeft = parseInt(paddingLeft, 10) + diffPaddingLeft;
 
        // redner
        var $placeholder = $('<span class="placeholder">');
        $placeholder.css({
            position: 'absolute',
            zIndex: '20',
            color: color,
            width: (width - paddingLeft) + 'px',
            height: height + 'px',
            fontSize: fontSize,
            paddingLeft: paddingLeft + 'px',
            fontFamily: fontFamily
        }).text(word).hide();
 
        // 位置调整
        move();
 
        // textarea 不加line-heihgt属性
        if ($that.is('input')) {
            $placeholder.css({
                lineHeight: height + 'px'
            });
        }
        $placeholder.appendTo(document.body);
 
        // 内容为空时才显示，比如刷新页面输入域已经填入了内容时
        var val = $that.val();
        if ( val == '' && $that.is(':visible') ) {
            $placeholder.show();
        }
 
        function hideAndFocus() {
            $placeholder.hide();
            $that[0].focus();
        }
        function move() {
            var offset = $that.offset();
            var top    = offset.top;
            var left   = offset.left;
            $placeholder.css({
                top: top,
                left: left
            });
        }
        function asFocus() {
            $placeholder.click(function() {
                hideAndFocus();
                // 盖住后无法触发input的click事件，需要模拟点击下
                setTimeout(function(){
                    $that.click();
                }, 100);
            });
            // IE有些bug，原本不用加此句
            $that.click(hideAndFocus);
            $that.blur(function() {
                var txt = $that.val();
                if (txt == '') {
                    $placeholder.show();
                }
            });
        }
        function asKeydown() {
            $placeholder.click(function() {
                $that[0].focus();
            });
        }
 
        if (evtType == 'focus') {
            asFocus();
        } else if (evtType == 'keydown') {
            asKeydown();
        }
 
        $that.keyup(function() {
            var txt = $that.val();
            if (txt == '') {
                $placeholder.show();
            } else {
                $placeholder.hide();
            }
        });
 
        // 窗口缩放时处理
        $(window).resize(function() {
            move();
        });
 
        // cache
        $that.data('el', $placeholder);
        $that.data('move', move);
 
    }
 
    return this.each(function() {
        var $elem = $(this);
        bootstrap($elem);
        if ($.isFunction(callback)) callback($elem);
    });
};