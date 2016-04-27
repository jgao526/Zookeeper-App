

angular.module('zooKeeperApp').controller('navCtrl', [
		'$scope', '$state',
		function ($scope,$state) {
'use strict';	

		$scope.activeLink = function(viewState) {
			return ($state.is(viewState) ? "active" : "");   
		}
		
		
}])