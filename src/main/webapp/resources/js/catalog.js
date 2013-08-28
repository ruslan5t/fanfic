
$(function() {
  var countItems, itemsOnPage;
  countItems = $("#countItems").attr("value");
  itemsOnPage = $("#countOnPage").attr("value");
  if (countItems > itemsOnPage) {
    return $("#pagination").pagination({
      items: countItems,
      currentPage: $("#pageNumber").attr("value"),
      itemsOnPage: itemsOnPage,
      cssStyle: "light-theme",
      onPageClick: function(pageNumber) {
        return window.location.replace($("#contextPath").attr("value") + "/catalog" + $("#addressPastCatalog").attr("value") + "/" + pageNumber);
      }
    });
  }
});