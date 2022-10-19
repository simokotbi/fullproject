$(document).ready(function () {
    var _dockPanel;
    var content = document.createElement('nav');
    content.innerHTML = '<a class="navbar-brand" href="Index.html">Pizza_POS</a>' +
        '<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">' +
        '<span class="navbar-toggler-icon"></span>' + '</button>';

    content.classList.add('navbar', 'navbar-expand-lg', 'navbar-dark', 'bg-dark', 'fixed-top')

    var navbarSupportedContent = document.createElement('div');
    navbarSupportedContent.classList.add('collapse', 'navbar-collapse');

    var navbar_nav = document.createElement('ul')
    navbar_nav.classList.add('navbar-nav','mr-auto')
    navbar_nav.innerHTML = '<li class="nav-item active"><a class="nav-link" href="Index.html">Home</a></li>'
    navbar_nav.innerHTML += '<li class="nav-item active"><a class="nav-link" href="NewOrder.html?">Order Page</a></li>'
    
    
    var out = document.createElement('li')
    out.classList.add('nav-item','dropdown');
    out.innerHTML = '<a id="ouut" class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Welcome: Name</a> \n';
    out.innerHTML +=  '<div class="dropdown-menu" aria-labelledby="navbarDropdown">\n<a class="dropdown-item" href="#">Logout </a>\n</div>\n';
   

    
    navbar_nav.append(out)


    content.appendChild(navbarSupportedContent);
    navbarSupportedContent.appendChild(navbar_nav);
    $("body").append(content);

    console.log('create')
});

