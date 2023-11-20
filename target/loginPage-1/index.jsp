<%-- 
    Document   : index
    Created on : 5 nov. 2023, 22:00:05
    Author     : nico_
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Login</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body class="d-flex align-items-center py-4 bg-body-tertiary">
        <main class="form-signin w-50 m-auto">
            <form action="login" method="POST"> <!-- Nota el action actualizado y el método POST -->
                <h1 class="h3 mb-3 fw-normal">Iniciar sesión</h1>

                <div class="form-floating">
                    <input type="text" class="form-control" id="floatingInput" name="username" placeholder="Username">
                    <label for="floatingInput">Username</label>
                </div>
                <div class="form-floating mt-2">
                    <input type="password" class="form-control" id="floatingPassword" name="password" placeholder="Password"> <!-- Y aquí -->
                    <label for="floatingPassword">Password</label>
                </div>


                <div id="error-message" class="alert alert-danger my-2" role="alert" 
                     style="<%= request.getAttribute("error") != null ? "display:block;" : "display:none;"%>">
                    <%= request.getAttribute("error")%>
                </div>

                <button class="btn btn-primary w-100 py-2 mt-5" type="submit">Iniciar sesión</button>
            </form>
        </main>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    </body>
</html>