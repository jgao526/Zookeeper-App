angular.module('zooKeeperApp', ['ui.router', 'ngAnimate', 'toaster', 'ui.bootstrap']);


angular.module('zooKeeperApp').config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
'use strict';

    $urlRouterProvider.otherwise('home');

    $stateProvider.state('foodpage', {

        url: '/foods',
        templateUrl: 'templates/food.tpl.html',
        controller: 'foodCtrl',
        
    }).state('home', {
    	url:'/home',
    	templateUrl: 'templates/home.tpl.html',
    	controller: 'homeCtrl',
    
    }).state('speciespage', {
    	url: '/species',
    	templateUrl: 'templates/species.tpl.html',
    	controller: 'speciesCtrl',
    
    }).state('animalpage', {
    	url: '/animal',
    	templateUrl: 'templates/animal.tpl.html',
    	controller: 'animalCtrl',
    
    }).state('enclosurepage', {
    	url: '/enclosure',
    	templateUrl: 'templates/enclosure.tpl.html',
    	controller: 'enclosureCtrl'
    });
    
    
}]);


angular.module('zooKeeperApp').controller('animalCtrl', [
		'$scope', 'toaster', 'animalFactory', 'speciesFactory', 'enclosureFactory',
		function ($scope,toaster, animalFactory, speciesFactory, enclosureFactory) {
'use strict';

		$scope.animalName = "";
		$scope.selectedSpecies = null;
		$scope.selectedEnclosure = null;
	    $scope.reverse = false;
	    $scope.formVisible = false;
	    $scope.updateFormVisible = false;
	    $scope.isUpdate = false;
	    $scope.showUpdateBtn = false;
	    $scope.currentPage = 1;
		$scope.maxSize = 5;
		$scope.itemsPerPage = 10;
		
		
		//get a list of animal
		animalFactory.getAnimalList().then(function(success){
			$scope.animalList = success.data;
			$scope.totalItems = success.data.length;
		}, function(error){
			toaster.pop('error', "Please try again later");
		})
		
		//get a list of enclosure
		enclosureFactory.getEnclosureList().then(function(success){
			$scope.enclosureList = success.data;
		}, function(error){
			toaster.pop('erro', "Please try again later");
		})
			
		//get a list of species
		speciesFactory.getSpeciesList().then(function(success){
			$scope.speciesList = success.data;
		}, function(error){
			toaster.pop('error', "Please try again later");
		})
		
		
		//update a selected animal
		$scope.updateAnimal = function(animal){
			animalFactory.updateAnimal(animal).then(function(success){
				toaster.pop('success', animal.name + "'s status has been updated");
			}, function(error){
				toaster.pop('error', "Please try again later");
			})
			
		}
		
		//create and add an animal
		$scope.createAnimal = function(){
			var animal = {};
			animal.species = {};
			animal.enclosure = {};
			animal.name = $scope.animalName.replace(/</g, "&lt").replace(/>/g, "&gt");
			animal.species = $scope.selectedSpecies;
			animal.enclosure = $scope.selectedEnclosure;
			animal.enclosure.animalTotal++;
			
			animalFactory.addAnimal(animal).then(function(success){
				
				toaster.pop('success', "New animal has been added");
				animalFactory.getAnimalList().then(function(success){
					$scope.animalList = success.data;

				})
			}, function(error){
				
				toaster.pop('error', "Please try again later");
			})
			
		}
		
		//reset form 
		$scope.resetForm = function(form){
			$scope.animalName = "";
			$scope.selectedSpecies = null;
			$scope.selectedEnclosure = null;
			form.$setUntouched();
		}
		
		
		$scope.orderBy = function ( orderProp ) {
			$scope.reverse = ( $scope.orderProp === orderProp ) ? !$scope.reverse : true;
			$scope.orderProp = orderProp;
		}
		
		$scope.enableUpdate = function() {
			$scope.updateFormVisible = true; 
			$scope.isUpdate = true; 
			$scope.showUpdateBtn = true;
		}
		
		$scope.disableUpdate = function() {
			$scope.updateFormVisible = false; 
			$scope.isUpdate = false; 
			$scope.showUpdateBtn = false;
		}
		
		
		 

		  
}])


angular.module('zooKeeperApp').controller('enclosureCtrl', [
		'$scope', 'toaster', 'enclosureFactory', 'animalFactory', 
		function ($scope, toaster, enclosureFactory, animalFactory) {
'use strict';

		$scope.enclosureName = "";
		$scope.startFeedTime = null;
		$scope.endFeedTime = null;
		$scope.enclosureCondition = "";
	    $scope.reverse = false;
	    $scope.formVisible = false;
	    $scope.updateFormVisible = false;
	    $scope.isUpdate = false;
	    $scope.showUpdateBtn = false;
	    $scope.hstep = 1;
	    $scope.mstep = 1;
	    $scope.currentPage = 1;
		$scope.maxSize = 5;
		$scope.itemsPerPage = 10;
		$scope.searchBy = "";
		
		//get a list of enclosures
	    enclosureFactory.getEnclosureList().then(function(success){
			$scope.enclosureList = success.data;
			$scope.totalItems = success.data.length;
			
		}, function(error){
			toaster.pop('error', "Please try again later");
		})
			
		
		//update a selected enclosure
		$scope.updateEnclosure = function(enclosure){
			
			enclosureFactory.updateEnclosure(enclosure).then(function(success){
				toaster.pop('success', "Selected enclosure has been updated")
			}, function(error){
				toaster.pop('error', "Please try again later");
			})
			
		}
		
		//create and add an enclosure
		$scope.createEnclosure = function(){
			var enclosure = {};
			
			enclosure.name = $scope.enclosureName.replace(/</g, "&lt").replace(/>/g, "&gt");
			enclosure.startFeedTime = $scope.startFeedTime;
			enclosure.endFeedTime = $scope.endFeedTime;
			enclosure.condition = $scope.enclosureCondition.replace(/</g, "&lt").replace(/>/g, "&gt");
			enclosure.animalTotal = 0;
			
			enclosureFactory.addEnclosure(enclosure).then(function(success){
				toaster.pop('success', "New enclosure has been added");
				enclosureFactory.getEnclosureList().then(function(success){
					$scope.enclosureList = success.data;
					
				})
			}, function(error){
				
				toaster.pop('error', "Please try again later");
			})
			
		}
		
		//remove an enclosure
		$scope.removeEnclosure = function(id){
			enclosureFactory.deleteEnclosure(id).then(function(success){
				 enclosureFactory.getEnclosureList().then(function(success){
						$scope.enclosureList = success.data;

					})
				toaster.pop('success', enclosure.name + " has been removed");
			}, function(error){
				toaster.pop('error', "Please try again later");
			})
		}
		
		//get a list of animals based on selected enclosure id
		$scope.getAnimalByEnId = function(id){
			animalFactory.getAnimalByEnclosureId(id).then(function(success){
				$scope.enclosureAnimals = success.data;
			
			},function(error){
				
				toaster.pop('error', "Please try again later");
			})
		}
		
		//get a list of enclosure based on reside animal's favorite food
		$scope.searchEnclosureByFavFood = function(){
			enclosureFactory.getEnclosureByFavFood($scope.searchBy).then(function(success){
				$scope.enclosureList = success.data;
				$scope.searchBy = "";
			},function(error){
				toaster.pop('error', "Please try again later");
			})
		}
		
		//reset form 
		$scope.resetForm = function(form){
			$scope.enclosureName = "";
			$scope.startFeedTime = null;
			$scope.endFeedTime = null;
			$scope.enclosureCondition = "";
			form.$setUntouched();
		}
		
		
		$scope.orderBy = function ( orderProp ) {
			$scope.reverse = ( $scope.orderProp === orderProp ) ? !$scope.reverse : true;
			$scope.orderProp = orderProp;
		}
		
		$scope.enableUpdate = function() {
			$scope.updateFormVisible = true; 
			$scope.isUpdate = true; 
			$scope.showUpdateBtn = true;
		}
		
		$scope.disableUpdate = function() {
			$scope.updateFormVisible = false; 
			$scope.isUpdate = false; 
			$scope.showUpdateBtn = false;
		}
}])


angular.module('zooKeeperApp').controller('foodCtrl', [
		'$scope', 'toaster', 'foodFactory',
		function ($scope,toaster, foodFactory) {
'use strict';		

			$scope.foodName = "";
			$scope.foodVendor = "";
			$scope.selectedCategory = null;
			$scope.reverse = false;
		    $scope.formVisible = false;
		    $scope.updateFormVisible = false;
		    $scope.isUpdate = false;
		    $scope.showUpdateBtn = false;
		    $scope.currentPage = 1;
			$scope.maxSize = 5;
			$scope.itemsPerPage = 10;
		
		//get a list of foods
		foodFactory.getFoodList().then(function(success){
			$scope.foodList = success.data;
			$scope.totalItems = success.data.length;
		}, function(error){
			toaster.pop('error', "Please try again later");
		})
		
		//get a list of food category
		foodFactory.getFoodCategory().then(function(success){
			$scope.foodCategoryList = success.data;
		}, function(error){
			toaster.pop('error', "Please try again later");
		})
		
		
		
		//update a selected food
		$scope.updateFood = function(food){
			foodFactory.updateFood(food).then(function(success){
				toaster.pop('success', "Selected food has been updated");
			}, function(error){
				toaster.pop('error', "Please try again later");
			})
			
		}
		
		//create and add a new food
		$scope.createFood = function(){
			var food = {};
			food.foodCategory = {};
			
			food.name = $scope.foodName.replace(/</g, "&lt").replace(/>/g, "&gt");
			food.vendor = $scope.foodVendor.replace(/</g, "&lt").replace(/>/g, "&gt");
			food.foodCategory = $scope.selectedCategory;
			
			foodFactory.addFood(food).then(function(success){
				toaster.pop('success', "New food has been added");
				foodFactory.getFoodList().then(function(success){
					$scope.foodList = success.data;

				})
			}, function(error){
				
				toaster.pop('error', "Please try again later");
			})
			
		}
		
		//reset form 
		$scope.resetForm = function(form){
			$scope.foodName = "";
			$scope.foodVendor = "";
			$scope.selectedCategory = null;
			form.$setUntouched();
		}
		
		
		$scope.orderBy = function ( orderProp ) {
			$scope.reverse = ( $scope.orderProp === orderProp ) ? !$scope.reverse : true;
			$scope.orderProp = orderProp;
		}
		
		$scope.enableUpdate = function() {
			$scope.updateFormVisible = true; 
			$scope.isUpdate = true; 
			$scope.showUpdateBtn = true;
		}
		
		$scope.disableUpdate = function() {
			$scope.updateFormVisible = false; 
			$scope.isUpdate = false; 
			$scope.showUpdateBtn = false;
		}
}])


angular.module('zooKeeperApp').controller('homeCtrl', [
		'$scope', 
		function ($scope) {
'use strict';

			$scope.welcomeMessage = "Welcome to Zoo Keeper App";
			
}]);


angular.module('zooKeeperApp').controller('navCtrl', [
		'$scope', '$state',
		function ($scope,$state) {
'use strict';	

		$scope.activeLink = function(viewState) {
			return ($state.is(viewState) ? "active" : "");   
		}
		
		
}])


angular.module('zooKeeperApp').controller('speciesCtrl', [
		'$scope', 'toaster', 'speciesFactory', 'foodFactory', 'animalFactory', 
		function ($scope,toaster, speciesFactory, foodFactory, animalFactory) {
'use strict';	

		$scope.speciesCommonName = "";
		$scope.speciesScientificName = "";
		$scope.speciesInfoLink = "";
		$scope.selectedFood = null;
	    $scope.reverse = false;
	    $scope.formVisible = false;
	    $scope.updateFormVisible = false;
	    $scope.isUpdate = false;
	    $scope.showUpdateBtn = false;
	    $scope.currentPage = 1;
		$scope.maxSize = 5;
		$scope.itemsPerPage = 10;
		
		//get a list of species
		speciesFactory.getSpeciesList().then(function(success){
			$scope.speciesList = success.data;
			$scope.totalItems = success.data.length;
		}, function(error){
			toaster.pop('error', "Please try again later");
		})
			
		//get a list of food
		foodFactory.getFoodList().then(function(success){
			$scope.foodList = success.data;
		}, function(error){
			toaster.pop('error', "Please try again later");
		})
		
		//get a list of animals based on the selected species's id
		$scope.getAnimalBySpeciesId = function(id) {
			animalFactory.getAnimalBySpeciesId(id).then(function(success){
				$scope.speciesAnimals = success.data;
			}, function(error){
				toaster.pop('error', "Please try again later");
			})
		}
		
		
		//update a selected species
		$scope.updateSpecies = function(species){
			
			speciesFactory.updateSpecies(species).then(function(success){
				toaster.pop('success', "Selected species has been updated")
			}, function(error){
				toaster.pop('error', "Please try again later");
			})
			
		}
		
		//create and add a species
		$scope.createSpecies = function(){
			var species = {};
			species.food = {};
			
			species.commonName = $scope.speciesCommonName;
			species.scientificName = $scope.speciesScientificName.replace(/</g, "&lt").replace(/>/g, "&gt");
			species.infoLink = $scope.speciesInfoLink.replace(/</g, "&lt").replace(/>/g, "&gt");
			species.food = $scope.selectedFood;
			
			speciesFactory.addSpecies(species).then(function(success){
				toaster.pop('success', "New species has been added");
				speciesFactory.getSpeciesList().then(function(success){
					$scope.speciesList = success.data;

				})
			}, function(error){
				
				toaster.pop('error', "Please try again later");
			})
			
		}
		
		//reset form 
		$scope.resetForm = function(form){
			$scope.speciesCommonName = "";
			$scope.speciesScientificName = "";
			$scope.speciesInfoLink = "";
			$scope.selectedFood = null;
			form.$setUntouched();
		}
		
		
		$scope.orderBy = function ( orderProp ) {
			$scope.reverse = ( $scope.orderProp === orderProp ) ? !$scope.reverse : true;
			$scope.orderProp = orderProp;
		}
		
		$scope.enableUpdate = function() {
			$scope.updateFormVisible = true; 
			$scope.isUpdate = true; 
			$scope.showUpdateBtn = true;
		}
		
		$scope.disableUpdate = function() {
			$scope.updateFormVisible = false; 
			$scope.isUpdate = false; 
			$scope.showUpdateBtn = false;
		}
}])

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