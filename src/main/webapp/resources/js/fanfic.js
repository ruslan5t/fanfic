
$(function() {

	var fanficId = $("#fanficId").attr("value");
	var contextPath = $("#contextPath").attr("value");
	
	$("#convertToPdf").on("click", convertFanficToPdf);
	
	function convertFanficToPdf() {
		$.ajax({
			url: contextPath + "/convertFanficToPdf/" + fanficId,
			type: "post",
			success: setHrefToConvertedFile 
		});
	}
	
	function setHrefToConvertedFile(hrefToConvertedFile) {
        var $iframe = $("<iframe></iframe>");
        $iframe.attr("src", hrefToConvertedFile);
        $iframe.css("display", "none");
        $("body").append($iframe);
	}
});