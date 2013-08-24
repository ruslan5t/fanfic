
$(function() {
	$.ajax({
		url: $("#contextPath").attr("value") + "/getTags",
		type: "post",
		success: setTagsAutocomplete
	});

	function setTagsAutocomplete(tags) {
		var tagsJSON = $.parseJSON(tags);
		function split( val ) {
			return val.split( /,\s*/ );
		}
		function extractLast( term ) {
			return split( term ).pop();
		}
		$( "#tags" )
		.bind( "keydown", function( event ) {
			if ( event.keyCode === $.ui.keyCode.TAB &&
					$( this ).data( "ui-autocomplete" ).menu.active ) {
				event.preventDefault();
			}
		})
		.autocomplete({
			source: function( request, response ) {
				response( $.ui.autocomplete.filter(
						tagsJSON, extractLast(request.term)).splice(0, 10));
			},
			focus: function() {
				return false;
			},
			select: function( event, ui ) {
				var terms = split( this.value );
				terms.pop();
				terms.push( ui.item.value );
				terms.push("");
				this.value = terms.join( ", " );
				return false;
			}
		});
	}
});