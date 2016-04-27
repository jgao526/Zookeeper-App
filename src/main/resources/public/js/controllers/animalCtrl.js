

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