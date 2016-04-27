'use strict'

module.exports = function(grunt) {

	require('load-grunt-tasks')(grunt);
	require('time-grunt')(grunt);
	grunt.loadNpmTasks('grunt-contrib-concat');
	grunt.loadNpmTasks('grunt-contrib-uglify');


	grunt.initConfig({
		concat: {
	        dist: {
	          src: ['src/main/resources/public/js/app.js',
	          	'src/main/resources/public/js/routes.js',
	          	'src/main/resources/public/js/**/*.js',
	          	'!src/main/resources/public/js/dist.js',
	          	'!src/main/resources/public/**/*.min.js'
	          ],

	          dest: 'src/main/resources/public/js/dist.js'
	        }
	      },

		uglify: {
		  options: {
		    // the banner is inserted at the top of the output
		    banner: '/*! <%= grunt.template.today("dd-mm-yyyy") %> */\n'
		  },
		  dist: {
		    files: {
		     'src/main/resources/public/js/dist.min.js': ['<%= concat.dist.dest %>']
		    }
		  }
		}
	});

	grunt.registerTask('build', [
		'concat', 
		'uglify'
	]);
	
	grunt.registerTask('default', 'build');
}