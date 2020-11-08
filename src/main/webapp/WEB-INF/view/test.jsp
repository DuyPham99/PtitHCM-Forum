<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link href="https://use.fontawesome.com/releases/v5.0.4/css/all.css"
	rel="stylesheet">
<link href="custom.css" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
	
</script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js">
	
</script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<link href="../css/style.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous">

<link href="../froala-editor/css/froala_editor.pkgd.min.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="../froala-editor/js/froala_editor.pkgd.min.js"></script>
<link href="../froala-editor/css/froala_style.min.css" rel="stylesheet"
	type="text/css" />
	

 </head>

<body>
  <div class="sample">
    <h2>File upload example.</h2>
    <form>
      <textarea id="edit" name="content"></textarea>
    </form>
  </div>

  <!-- Include Editor JS files. -->
  <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/froala-editor@3.1.0//js/froala_editor.pkgd.min.js"></script>

  <!-- Initialize the editor. -->
  <script>
    new FroalaEditor('#edit', {
      // Set the image upload URL.
      imageUploadURL: '/upload_image',
      imageUploadParams: {
        id: 'my_editor'
      }
    })
  </script>
</body>
</html>