<html>
  <head>
    <title>${message(code:'home.title.browsers')}</title>
    <meta name="layout" content="fo_main" />
  </head>
  <body>
    <div class="main-box">
      <h2>${message(code:'home.header.browsers')}</h2>
      <ul class="browsers">
        <li>
            <img src="${resource(dir:'images/browsers',file:'internet_explore.png')}" />
            <h3>Internet Explorer 8</h3>
            <p>et versions supérieures</p>
        </li>
        <li>
            <img src="${resource(dir:'images/browsers',file:'firefox.png')}" />
            <h3>Firefox 4</h3>
            <p>et versions supérieures</p>
        </li>
        <li>
            <img src="${resource(dir:'images/browsers',file:'google_chrome.png')}" />
            <h3>Google Chrome 10</h3>
            <p>et versions supérieures</p>
        </li>
        <li>
            <img src="${resource(dir:'images/browsers',file:'apple_safari.png')}" />
            <h3>Safari 4</h3>
            <p>et versions supérieures</p>
        </li>
      </ul>
    </div>
  </body>
</html>