define([
		"dojox/form/Uploader",
		"dojo/dom",
		"dojox/form/uploader/FileList",
		"dijit/form/Button",
		"dojo/domReady!"
		], function(Uploader,dom,FileList,Button)
		{
		    var oldText = {};
		 
		    // This returned object becomes the defined value of this module
		    return {
		        setText: function (id, text) {
		            var node = dom.byId(id);
		            oldText[id] = node.innerHTML;
		            node.innerHTML = text;
		        },
		 
		        restoreText: function (id) {
		            var node = dom.byId(id);
		            node.innerHTML = oldText[id];
		            delete oldText[id];
		        }
		    };
		});


require(["dojox/form/Uploader",
         "dojo/dom",
         "dojox/form/uploader/FileList",
         "dijit/form/Button",
	         "dojo/domReady!"],
		         function(Uploader,dom,FileList,Button)
		         {
				var up = new Uploader({
		            label: 'Select files',
		            multiple: true,
		            class:"browseButton",
		            url: "uploadMultipleFile.json",
		            name: "uploadedfile"
	        	},"uploaderDiv");

		        list = new FileList({
		            uploader: up
		        },"filelistDiv");
		
		        btn = new Button({
		            label: 'upload',
		            onClick: function() {
		                up.upload();
		            }
		        },"buttonDiv");
		
		        dojo.connect(up, "onComplete", function(dataArray) {
		            var i = 0;			            
		            dom.byId("uploaderStatus").innerHTML = "";			            
		            if (!dataArray.error) {
		                for (i = 0; i < dataArray.length; ++i) {
		                	dom.byId("uploaderStatus").innerHTML += "File ID is: " + dataArray[i].id + " is uploaded" + "<br/>";
		                }
		            } else {
		            	dom.byId("uploaderStatus").innerHTML = "Unable to upload the file(s)";
		            }
		        });    
		        
		        
		        btn.startup();
		        up.startup();
		        list.startup();
		 	});