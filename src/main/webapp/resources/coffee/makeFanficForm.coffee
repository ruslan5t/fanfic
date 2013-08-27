
$ ->
	setTagsAutocomplete = (tags) ->
		tagsJSON = $.parseJSON(tags)
		split = (val) -> return val.split( /,\s*/ )
		extractLast = (term) -> return split(term).pop()
		$("#tags").bind("keydown", (event) ->
			if (event.keyCode == $.ui.keyCode.TAB and $(this).data("ui-autocomplete").menu.active)
				event.preventDefault()
		).autocomplete({
			source: (request, response) ->
				response($.ui.autocomplete.filter(tagsJSON, extractLast(request.term)).splice(0, 10))
			focus: -> return false,
			select: (event, ui) ->
				terms = split(this.value)
				terms.pop()
				terms.push(ui.item.value)
				terms.push("")
				this.value = terms.join(", ")
				return false
		})
	$.ajax({
		url: $("#contextPath").attr("value") + "/getTags",
		type: "post",
		success: setTagsAutocomplete
	})