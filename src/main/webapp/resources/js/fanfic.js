
$(function() {
  var convertFanficToPdf, setHrefToConvertedFile;
  setHrefToConvertedFile = function(hrefToConvertedFile) {
    var $iframe;
    $iframe = $("<iframe></iframe>");
    $iframe.attr("src", hrefToConvertedFile);
    $iframe.css("display", "none");
    return $("body").append($iframe);
  };
  convertFanficToPdf = function() {
    return $.ajax({
      url: $("#contextPath").attr("value") + "/convertFanficToPdf/" + $("#fanficId").attr("value"),
      type: "post",
      success: setHrefToConvertedFile
    });
  };
  return $("#convertToPdf").on("click", convertFanficToPdf);
});