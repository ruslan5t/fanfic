
$(function() {
  var $tags;
  $tags = $("#tags");
  return $tags.attr("value", $tags.attr("value").replace(",", ", "));
});