
angular.module('zooKeeperApp').factory('speciesFactory',
		[ '$http', function($http) {
'use strict';
			return {
				
				getSpeciesList : function() {
					return $http.get("/species");
				},
				updateSpecies : function(species) {
					return $http.put("/species", species);
				},
				addSpecies : function(species) {
					return $http.post("/species", species);
				},
				getSpeciesById : function(id) {
					return $http.get("/species/" + id);
				}
			}

}]);