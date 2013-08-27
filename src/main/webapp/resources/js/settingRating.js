$(function() {
  var $rating, baseRatyOptions, contextPath, setFanficRating, setUsersRating;
  $rating = $(".rating");
  contextPath = $("#contextPath").attr("value");
  baseRatyOptions = {
    path: contextPath + "/resources/js/img/"
  };
  setFanficRating = function(fanficRating, $ratingElement) {
    return $ratingElement.raty("score", fanficRating);
  };
  setUsersRating = function(rating) {
    var $ratingElement;
    $ratingElement = $(this);
    return $.ajax({
      url: contextPath + "/setFanficRating/" + $ratingElement.attr("fanficId") + "/" + rating,
      type: "post",
      success: function(fanficRating) {
        return setFanficRating(fanficRating, $ratingElement);
      }
    });
  };
  if ($("#isLogged").attr("value") === "true") {
    return $rating.each(function() {
      var rating;
      rating = $(this).attr("rating");
      return $(this).raty($.extend({
        click: setUsersRating,
        score: rating
      }, baseRatyOptions));
    });
  } else {
    return $rating.each(function() {
      var rating;
      rating = $(this).attr("rating");
      return $(this).raty($.extend({
        readOnly: true,
        score: rating
      }, baseRatyOptions));
    });
  }
});