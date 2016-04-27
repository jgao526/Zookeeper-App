

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