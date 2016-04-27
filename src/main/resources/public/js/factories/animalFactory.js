
angular.module('zooKeeperApp').factory('animalFactory',
		[ '$http', function($http) {
'use strict';

			return {
				getAnimalList : function() {
					return $http.get("/animal");
				},
				updateAnimal : function(animal) {
					return $http.put("/animal", animal);
				},
				addAnimal : function(animal) {
					return $http.post("/animal", animal);
				},
				getAnimalById : function(id) {
					return $http.get("/animal/" + id);
				},
				getAnimalByEnclosureId : function(id) {
					return $http.get("/animal/enclosure/" + id);
				},
				getAnimalBySpeciesId : function(id) {
					return $http.get("/animal/species/" + id);
				}
			}

}]);