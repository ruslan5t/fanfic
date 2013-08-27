$(function() {
  var setTagsAutocomplete;
  setTagsAutocomplete = function(tags) {
    var extractLast, split, tagsJSON;
    tagsJSON = $.parseJSON(tags);
    split = function(val) {
      return val.split(/,\s*/);
    };
    extractLast = function(term) {
      return split(term).pop();
    };
    return $("#tags").bind("keydown", function(event) {
      if (event.keyCode === $.ui.keyCode.TAB && $(this).data("ui-autocomplete").menu.active) {
        return event.preventDefault();
      }
    }).autocomplete({
      source: function(request, response) {
        return response($.ui.autocomplete.filter(tagsJSON, extractLast(request.term)).splice(0, 10));
      },
      focus: function() {
        return false;
      },
      select: function(event, ui) {
        var terms;
        terms = split(this.value);
        terms.pop();
        terms.push(ui.item.value);
        terms.push("");
        this.value = terms.join(", ");
        return false;
      }
    });
  };
  return $.ajax({
    url: $("#contextPath").attr("value") + "/getTags",
    type: "post",
    success: setTagsAutocomplete
  });
});