<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Upload CSS</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <div class="container mt-5">
        <div class="card">
            <div class="card-header">
                <h5 class="card-title">Upload CSS</h5>
            </div>
            <div class="card-body">
                <form action="CssServlet" method="post" enctype="multipart/form-data">
                    <div class="mb-3">
                        <label for="cssFile" class="form-label">Choose a CSS file</label>
                        <input type="file" class="form-control" id="cssFile" name="cssFile" accept=".css">
                    </div>
                    <button type="submit" class="btn btn-primary">Upload</button>
                </form>
            </div>
        </div>
    </div>

</body>
</html>
