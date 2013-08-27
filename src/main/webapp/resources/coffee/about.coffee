
$ ->
	$.ajax({
		url: $("#contextPath").attr("value") + "/getStatistics",
		type: "post",
		success: setStatistics
	})
	setStatistics = (statistics) ->
		statisticsJSON = $.parseJSON(statistics)
		$("#chartContainer").plot([ statisticsJSON ], {
			series: {
				bars: {
					show: true,
					barWidth: 0.6,
					align: "center"
				}
			},
			xaxis: {
				mode: "categories",
				tickLength: 0
			},
			yaxis: {
				min: 0,
				minTickSize: 1
			}
		})