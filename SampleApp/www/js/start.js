'use strict';

const vConsole = new VConsole();
//window.datgui = new dat.GUI();

var vue_options = {
    el: "#top",
    mixins: [mixins_bootstrap],
    data: {
    },
    computed: {
    },
    methods: {
    	func1_call: async function(){
    		var result = await sampleplugin.func1(1234, "Hello World", [0, 1, 2, 3, 4]);
    		console.log(JSON.stringify(result));
    		alert("func1 called");
    	},
    	func2_call: async function(){
    		var result = await sampleplugin.func2("int");
    		console.log(JSON.stringify(result));
    		var result = await sampleplugin.func2("string");
    		console.log(JSON.stringify(result));
    		var result = await sampleplugin.func2("array");
    		console.log(JSON.stringify(result));
    		alert("func2 called");
    	},
    },
    created: function(){
    },
    mounted: function(){
        proc_load();
    }
};
vue_add_data(vue_options, { progress_title: '' }); // for progress-dialog
vue_add_global_components(components_bootstrap);
vue_add_global_components(components_utils);

/* add additional components */
  
window.vue = new Vue( vue_options );
