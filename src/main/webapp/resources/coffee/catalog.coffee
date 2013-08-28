
$ ->
	countItems = $("#countItems").attr("value")
	itemsOnPage = $("#countOnPage").attr("value")
	if countItems > itemsOnPage
 		$("#pagination").pagination({
 			items: countItems,
			currentPage: $("#pageNumber").attr("value"),
			itemsOnPage: itemsOnPage,
			cssStyle: "light-theme",
			onPageClick: (pageNumber) ->
				window.location.replace($("#contextPath").attr("value") + 
					"/catalog" + $("#addressPastCatalog").attr("value") + "/" + pageNumber)
 		})