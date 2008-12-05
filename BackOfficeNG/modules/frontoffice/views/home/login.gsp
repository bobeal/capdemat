<html>
  <head>
    <meta name="layout" content="fong_main" />
  </head>
  
  <body>
  
      <div class="yui-g login-box"> 
        <div class="yui-u first">
          <h2>Login</h2>
          <form id="loginForm" method="post" action="${createLink(action:'login')}" >
          
            <label for="login">Login</label>
            <input type="text" name="login" />
            
            <label for="password">Password</label>
            <input type="password" name="password" />
            
            <a href="">Forgot your password ?</a>
          </form>
        </div> 
        <div class="yui-u">
          <h2>Create an account</h2>
          
          By creating an account, you will acces to
          <ul>
            <li>all request</li>
            <li>Family account advanced managment feature</li>
            <li>Payment managment</li>
            <li>Document managment</li>
            <li>A new life without stress !</li>
          </ul>
          <a id="voCardRequestLink" href="VoCardRequestCreation">Create an account</a>
        </div>
      </div>
       
      <div class="yui-g">
        <div class="yui-u first">
        
        <g:each var="group" in="${groups}" status="i">
          <div class="group-box">
            <h3>${group.key}</h3>
            <ul>
            <g:each var="rtLabel" in="${group.value}">
              <li><a href=""><g:translateRequestTypeLabel label="${rtLabel}"/></a></li>
            </g:each>
            </ul>
          </div>
          <g:if test="${(groups.size() - 2) / 2 < i }">  
            </div>
            <div class="yui-u">
          </g:if>
        </g:each>

        </div> 
        
      </div>

  </body>
</html>

