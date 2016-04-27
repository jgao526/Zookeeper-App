
angular.module('zooKeeperApp').factory('enclosureFactory',
		[ '$http', function($http) {
'use strict';			
			return {
				
				getEnclosureList : function() {
					return $http.get("/enclosure");
				},
				updateEnclosure : function(enclosure) {
					return $http.put("/enclosure", enclosure);
				},
				addEnclosure : function(enclosure) {
					return $http.post("/enclosure", enclosure);
				},
				deleteEnclosure : function(id) {
					return $http.delete("/enclosure/" +  id);
				},
				getEnclosureById : function(id) {
					return $http.get("/enclosure/" + id);
				},
				getEnclosureByFavFood : function (foodName) {
					return $http.get("/enclosure/favfood/" + foodName);
				}
			}

}]);