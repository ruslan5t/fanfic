
$(function() {
  var countItems, itemsOnPage;
  countItems = parseInt($("#countItems").attr("value"));
  itemsOnPage = parseInt($("#countOnPage").attr("value"));
  if (countItems > itemsOnPage) {
    return $("#pagination").pagination({
      items: countItems,
      currentPage: parseInt($("#pageNumber").attr("value")),
      itemsOnPage: itemsOnPage,
      cssStyle: "light-theme",
      onPageClick: function(pageNumber) {
        return window.location.replace($("#contextPath").attr("value") + "/catalog" + $("#addressPastCatalog").attr("value") + "/" + pageNumber);
      }
    });
  }
});