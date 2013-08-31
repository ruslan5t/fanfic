$(function() {
  var $fontSizes, $option, $resizableChapterPlace, $widthRange, fontSize, setChapterWidth, setFontSize, setWidtByWidthRange, userChapterWidth, userFontSize;
  userFontSize = parseInt($.cookie("userFontSize"));
  $resizableChapterPlace = $("#resizableChapterPlace");
  $widthRange = $("#widthRange");
  setFontSize = function(fontSize) {
    $resizableChapterPlace.css("font-size", fontSize);
    $resizableChapterPlace.css("line-height", 1);
    return $.cookie("userFontSize", fontSize, {
      expires: 1
    });
  };
  setChapterWidth = function(chapterWidth) {
    var maxWidth, minWidth;
    maxWidth = parseFloat($resizableChapterPlace.css("max-width"));
    minWidth = parseFloat($resizableChapterPlace.css("min-width"));
    $resizableChapterPlace.css("width", minWidth + (chapterWidth * (maxWidth - minWidth)) / 100);
    $widthRange.val(chapterWidth);
    return $.cookie("userChapterWidth", chapterWidth, {
      expires: 1
    });
  };
  if (userFontSize === null) {
    userFontSize = parseInt($resizableChapterPlace.css("font-size"));
  }
  setFontSize(userFontSize);
  if ($.cookie("userChapterWidth") === null) {
    userChapterWidth = 100;
  } else {
    userChapterWidth = parseInt($.cookie("userChapterWidth"));
  }
  setChapterWidth(userChapterWidth);
  $fontSizes = $("#fontSizes");
  fontSize = 10;
  while (fontSize <= 32) {
    fontSize += 2;
    $option = $("<option></option>");
    if (fontSize === userFontSize) {
      $option.attr("selected", "selected");
    }
    $option.text(fontSize);
    $fontSizes.append($option);
  }
  $fontSizes.change(function() {
    return setFontSize(parseInt($(this).val()));
  });
  setWidtByWidthRange = function() {
    return setChapterWidth($widthRange.val());
  };
  return $widthRange.bind("change", setWidtByWidthRange);
});