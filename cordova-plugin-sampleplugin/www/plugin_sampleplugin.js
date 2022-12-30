class SamplePlugin{
	constructor(){
	}

	func1(param1, param2, param3){
		return new Promise(function(resolve, reject){
			cordova.exec(
				function(result){
					resolve(result);
				},
				function(err){
					reject(err);
				},
				"SamplePlugin", "func1",
				[param1, param2, param3]);
		});
	}

	func2(return_type){
		return new Promise(function(resolve, reject){
			cordova.exec(
				function(result){
					resolve(result);
				},
				function(err){
					reject(err);
				},
				"SamplePlugin", "func2",
				[return_type]);
		});
	}

	func3(enable, callback){
		cordova.exec(
			function(result){
				callback(result);
			},
			function(err){
				console.error("func3 call failed");
			},
			"SamplePlugin", "func3",
			[enable]);
	}
}

module.exports = new SamplePlugin();
