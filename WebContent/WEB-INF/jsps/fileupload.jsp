<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="./resources/dijit/themes/claro/claro.css">
	<style type="text/css">
			html, body {
			    width: 100%;
			    height: 100%;
			    margin: 0;
			    overflow:hidden;
			}
			
			#borderContainer {
			    width: 100%;
			    height: 100%;
			}
	</style>
	<script>dojoConfig = {parseOnLoad: true}</script>
	<script src="./resources/dojo/dojo.js"></script>
	<script type="text/javascript">
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
 	</script>
</head>
<body class="claro">
<p>Upload Files: </p>
<div id="uploaderDiv"></div>
<div id="filelistDiv"></div>
<div id="uploaderStatus"></div>
<div id="buttonDiv"></div>
</body>
</html>