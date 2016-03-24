/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function() {
	$('#search').click(function() {
		$.post("Search", { query: $('#query').val() }, function(result) {
			$('#results').html(result);
			setLiClickListener();
		})
	})
})


function setLiClickListener() {
	$('li').on('click', function() {
		var productId = $(this).attr("data-product-id");
		$.post("AddProuct", { productId: productId }, function(result) {
			console.log("Success");
		})
	})
}