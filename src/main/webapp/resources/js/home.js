
$(function() {
	$("#chartContainer").dxChart({
	    dataSource: [
	        {day: "1", oranges: 65},
	        {day: "2", oranges: 2},
	        {day: "3", oranges: 3},
	        {day: "4", oranges: 4},
	        {day: "5", oranges: 6},
	        {day: "6", oranges: 11},
	        {day: "7", oranges: 4},
			{day: "8", oranges: 11},
			{day: "9", oranges: 11},
			{day: "10", oranges: -54}],
	 
	    series: {
	        argumentField: "day",
	        valueField: "oranges",
	        name: "My oranges",
	        type: "bar",
	        color: "orange"
	    }
	});
	$("#tagcloud").tagoSphere({
		radius: 50
	});
});