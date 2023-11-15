<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<style type="text/css">
.container {
  max-width: 500px;
}

.form-control {
  border-radius: 5px;
  box-shadow: 0 0 5px rgba(0, 0, 0, 0.25);
  border: 1px solid #ccc;
}

.btn-primary {
  background-color: #3897f0;
  border-color: #3897f0;
}

.btn-primary:hover {
  background-color: #2879bd;
  border-color: #2879bd;
}

.mt-3 {
  margin-top: 3rem;
}

.d-flex {
  display: flex;
}

.justify-content-center {
  justify-content: center;
}

.btn-outline-primary {
  border: 1px solid #3897f0;
  color: #3897f0;
}

.btn-outline-primary:hover {
  background-color: #3897f0;
  color: #fff;
}

</style>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Employee Login Page</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
  <div class="container">
    <div class="row justify-content-center align-items-center mt-5">
      <div class="col-md-4">
      <div class="d-flex justify-content-center ">
        <h2>Employee Login</h2>
        </div>
        <form action="/login" method="post">
          <div class="mb-3">
            <label for="username" class="form-label">Username or Email</label>
            <input type="text" class="form-control" id="username" name="username">
          </div>
          <div class="mb-3">
            <label for="password" class="form-label">Password</label>
            <input type="password" class="form-control" id="password" name="password">
          </div>
          <div class="d-flex justify-content-center ">
          <button type="submit" class="btn btn-primary">Log in</button>
          </div>
        </form>
        <div class="d-flex justify-content-center ">
        <a href="/forgot-password" class="mt-3">Forgot password?</a>
        </div>
        <div class="d-flex justify-content-center ">
        <p class="mt-3">Don't have an account? <a href="/signup">Sign up</a></p>
        </div>
        <div class="d-flex justify-content-center mt-3">
          <a href="#" class="btn btn-outline-primary">Log in with EmployeeID</a>
        </div>
      </div>
    </div>
  </div>
</body>
</html>
