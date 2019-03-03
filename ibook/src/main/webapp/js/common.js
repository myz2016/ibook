function createTR() {
    return createNode("<tr></tr>");
}

function createTD(value) {
    var td = undefined;
    switch (arguments.length) {
        case 1:
            td = createNode("<td>" + arguments[0] + "</td>");
            td.attr("title", arguments[0]);
            td.attr("nowrap", "nowrap");
            break;
        default:
            td = createNode("<td></td>");
            break;
    }
    return td;
}

/**
 * 插入行
 * 一共需要两种参数类型，第一种是索引，即要插入的行
 * 第二种是行中的列，第二种参数可以有多个。会根据TD
 * 传入的先后顺序，依次加入到行中。
 * @param index 要插入到的行的索引
 * @param arrTD 列
 */
function insertRow(index, arrTD) {
    if (arguments.length == 0 || index < 0) {
        return;
    }
    var _index = arguments[0];
    var tr = createTR();
    for(var i = 1; i < arguments.length; i++) {
        arguments[i].appendTo(tr);
    }
    $("tr:eq(" + _index + ")").before(tr);
}


/**
 * 创建带有默认边框的TD
 * @param tdValue TD中的值
 * @param tdWidth TD的宽度
 * @param tdRowSpanLength TD所占行数量
 * @param tdColSpanLength TD所占列数量
 * @returns td
 */
function createTDWithBorderDef(tdValue, tdWidth, tdRowSpanLength, tdColSpanLength) {
    var td = undefined;
    switch (arguments.length) {
        case 1:
            td = createTD(arguments[0]);
            break;
        case 2:
            td = createTD(arguments[0]);
            setWidth(td, arguments[1]);
            break;
        case 3:
            td = createTD(arguments[0]);
            setWidth(td, arguments[1]);
            tdRowSpan(td, arguments[2]);
        case 4:
            td = createTD(arguments[0]);
            setWidth(td, arguments[1]);
            tdRowSpan(td, arguments[2]);
            tdColspan(td, arguments[3]);
            break;
        default:
            td = createTD();
            break;

    }
    setAlign(td, "center");
    setBorderDefault(td);
    return td;
}

function createTable() {
    var tab = createNode("<table></table>");
    borderCollapse(tab);
    tab.attr("cellspacing", "0");
    tab.attr("cellpadding", "0");
    return tab;
}
/**
 * 边框默认1px、实线
 * @param node
 */
function setBorderDefault(node) {
    node.css("border", "1px solid");
}

function borderCollapse(node) {
    node.css("border-collapse", "collapse");
}

function setWidth(node, value) {
    node.css("width", value);
}

function tdColspan(node, length) {
    node.attr("colspan", length);
}

function tdRowSpan(node, length) {
    node.attr("rowspan", length);
}

function setAlign(node, value) {
    node.attr("align", value);
}
function createNode(node) {
    return $(node);
}