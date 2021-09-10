<#-- @ftlvariable name="entries" type="kotlin.collections.List<com.jetbrains.handson.website.BlogEntry>" -->
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="An example to show API call with coroutines using dagger hilt and writing Unit Test cases with Dagger Hilt">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0">
    <title>Ktor REST API</title>
    <meta property="og:image" content="http://api.ravishrajput.com/images/ktor-rest-apis-open-graph.png"/>
    <meta property="og:image:width" content="1200"/>
    <meta property="og:image:height" content="627"/>
    <script src="https://cdn.jsdelivr.net/gh/google/code-prettify@master/loader/run_prettify.js"></script>

    <link rel="shortcut icon" href="images/code.png">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:regular,bold,italic,thin,light,bolditalic,black,medium&amp;lang=en">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.teal-red.min.css">
    <link rel="stylesheet" href="styles.css">
    <style>
    #view-source {
      position: fixed;
      display: block;
      right: 0;
      bottom: 0;
      margin-right: 40px;
      margin-bottom: 40px;
      z-index: 900;
    }
      p{
        font-size: 20px;
      }
    </style>
  </head>
  <body>
    <div class="demo-layout mdl-layout mdl-layout--fixed-header mdl-js-layout mdl-color--grey-100">
      <header class="demo-header mdl-layout__header mdl-layout__header--scroll mdl-color--grey-100 mdl-color-text--grey-800">
        <div class="mdl-layout__header-row">
          <span class="mdl-layout-title">Ktor REST API</span>
          <div class="mdl-layout-spacer"></div>
        </div>
      </header>
      <div class="demo-ribbon"></div>
      <main class="demo-main mdl-layout__content">
        <div class="demo-container mdl-grid">
          <div class="mdl-cell mdl-cell--2-col mdl-cell--hide-tablet mdl-cell--hide-phone"></div>
          <div class="demo-content mdl-color--white mdl-shadow--4dp content mdl-color-text--grey-800 mdl-cell mdl-cell--8-col">

            <h3>Ktor Dummy REST APIs</h3>
              <p>
                In order to work with other sample Projects which requires API calls. I badly needed a dummy APIs, so I thought of
                owning a one.
              </p>
              <p>This page is all about how to use it.</p>
              <br>

              <div><img class="responsive" width="900" src="images/ktor-rest-apis.png"></div>
              <br><br>

<h4>Endpoints</h4>
            <table>
              <tr>
                <th>Endpoint</th>
                <th>Request</th>
                <th>Description</th>
              </tr>
              <tr>
                <td><span>/v1/user</span></td>
                <td>GET</td>
                <td>Response of All Users</td>
              </tr>
              <tr>
                <td>/v1/user/{id}</td>
                <td>GET</td>
                <td>Get Specific User by Id</td>
              </tr>
              <tr>
                <td>/v1/user/{id}</td>
                <td>DELETE</td>
                <td>Delete the user data</td>
              </tr>
              <tr>
                <td>/v1/user</td>
                <td>POST</td>
                <td>Add a new User</td>
              </tr>
            </table>
            <br><br>
            <p>GET /v1/user : get all users list</p>
            <p>Response:</p>
            <script src="https://gist.github.com/ravishrajput/4e3eb4298c43d847e35e4296431bb54a.js"></script>

            <br><br>
            <p>GET /v1/user/{id} : get user by id</p>
            <p>Response:</p>
            <script src="https://gist.github.com/ravishrajput/67da3574eafc21973584d1bcef6c8ed1.js"></script>

            <br><br>
            <p>DELETE /v1/user/{id} : delete a user details by id</p>
            <p>Response:</p>
            <script src="https://gist.github.com/ravishrajput/2693e6a60fcfba6a553658dfe113df0a.js"></script>

            <br><br>
            <p>POST /v1/user : Add new User Data</p>
            <p>Request Params:</p>
            <table>
              <tr>
                <th>Key</th>
                <th>Type</th>
              </tr>
              <tr>
                <td>name</td>
                <td>String</td>
              </tr>
              <tr>
                <td>username</td>
                <td>String</td>
              </tr>
              <tr>
                <td>email</td>
                <td>String</td>
              </tr>
              <tr>
                <td>imageUrl</td>
                <td>String</td>
              </tr>
            </table>
            <br>
            <p>Response:</p>
            <script src="https://gist.github.com/ravishrajput/7a4836690cfb7926cb6c46f75db674e2.js"></script>
            <br>
            <p>NOTE: If you want to use this API service in any of your example projects, you would require a Basic Authorization to access it.</p>
          </div>
        </div>
        <footer class="demo-footer mdl-mini-footer">
          <div class="mdl-mini-footer--left-section">
            <ul class="mdl-mini-footer--link-list">
              <!-- <li><a href="#">Help</a></li>
              <li><a href="#">Privacy and Terms</a></li> -->
              <li><a href="https://github.com/ravishrajput/ktor-rest-api-example/blob/main/LICENSE" target="_blank">Terms of Use</a></li>
            </ul>
          </div>
        </footer>
      </main>
    </div>
    <!-- The Modal -->
<div id="myModal" class="modal">
  <span class="close">&times;</span>
  <img class="modal-content" id="img01">
  <div id="caption"></div>
</div>

    <a href="https://github.com/ravishrajput/ktor-rest-api-example" target="_blank" id="view-source" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-color--accent mdl-color-text--accent-contrast">View Source</a>
    <script src="https://code.getmdl.io/1.3.0/material.min.js"></script>
  </body>
</html>