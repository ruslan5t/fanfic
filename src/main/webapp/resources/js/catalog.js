
$(function() {
  return $("#pagination").pagination({
    items: $("#countItems").attr("value"),
    currentPage: $("#pageNumber").attr("value"),
    itemsOnPage: $("#countOnPage").attr("value"),
    cssStyle: "light-theme",
    onPageClick: function(pageNumber) {
      return window.location.replace($("#contextPath").attr("value") + "/catalog" + $("#addressPastCatalog").attr("value") + "/" + pageNumber);
    }
  });
});