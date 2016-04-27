
angular.module('zooKeeperApp').factory('foodFactory',
		[ '$http', function($http) {
'use strict';
			return {
				
				getFoodList : function() {
					return $http.get("/foods");
				},
				updateFood : function(food) {
					return $http.put("/foods", food);
				},
				addFood : function(food) {
					return $http.post("/foods", food);
				},
				getFoodById : function(id) {
					return $http.get("/foods/" + id);
				},
				getFoodCategory : function(){
					return $http.get("/foods/category");
				}
			}

}]);