
$(document).ready(function () {
    $('[data-toggle="tooltip"]').tooltip();
});
let today = new Date().toDateString();
document.getElementById("date").innerHTML = today;
const main = async () => {
    var url = 'http://localhost:8083/api/article?page=1&pagesize=30';
    var reponse = await fetch(url);
    var data = await reponse.json();
    renderSlide0(data);
    renderSlide1(data);
    renderSlide2(data);
    renderSlide3(data);
    renderSlide4(data);
    renderSlide6(data);
}
const renderSlide0 = (data) => {
    var domSlide = document.querySelector("#carousel")
    var html = '';
    //i<=2 but error
    for (let i = 0; i <= 0; i++) {
        var date = new Date(data[i].publishedAt).toLocaleString();
        html += `
              <div class="position-relative overflow-hidden" style="height: 500px;">
                            <img class="img-fluid h-100" src="${data[i].urlToImage}" style="object-fit: cover; height:500px ; width:800px">
                            <div class="overlay">
                                <div class="mb-2">
                                    <a class="badge badge-primary text-uppercase font-weight-semi-bold p-2 mr-2"
                                        href="${data[i].url}">${data[i].name}</a>
                                    <a class="text-white" href="${data[i].url}">${date}</a>
                                </div>
                                <a class="h2 m-0 text-white text-uppercase font-weight-bold" id="title" href="${data[i].url}">${data[i].title}</a>
                            </div>
                        </div>
                `;
    }
    ;
    domSlide.innerHTML = html;
}

const renderSlide1 = (data) => {
    var domSlide = document.querySelector("#content1")
    var html = '';
    for (let i = 1; i <= 4; i++) {
        var date = new Date(data[i].publishedAt).toLocaleString();
        html += `
              <div class="col-md-6 px-0">
                        <div class="position-relative overflow-hidden" style="height: 250px;">
                            <img class="img-fluid w-100 h-100" src="${data[i].urlToImage}" style="object-fit: cover;">
                            <div class="overlay">
                                <div class="mb-2">
                                    <a class="badge badge-primary text-uppercase font-weight-semi-bold p-2 mr-2"
                                        href="${data[i].url}">${data[i].name}</a><br>
                                    <a class="text-white small" href="${data[i].url}">${date}</a>
                                </div>
                                <a id="title" data-toggle="tooltip" title="${data[i].title}" class="h6 m-0 text-white text-uppercase font-weight-semi-bold" href="${data[i].url}">${data[i].title}</a>
                            </div>
                        </div>
                    </div>
                `;
    }
    ;
    domSlide.innerHTML = html;
}
const renderSlide2 = (data) => {
    var domSlide = document.querySelector("#breakingnew")
    var html = '';
    for (let i = 0; i <= 2; i++) {
        html += `
              <div class="text-truncate"><a  data-toggle="tooltip" title="${data[i].title}" class="text-white text-uppercase font-weight-semi-bold" href="${data[i].url}">${data[i].title}</a></div>
                `;
    }
    ;
    domSlide.innerHTML = html;
}
const renderSlide3 = (data) => {
    var domSlide = document.querySelector("#content3")
    var html = '';
    html += `
             <div class="col-12">
                            <div class="section-title">
                                <h4 class="m-0 text-uppercase font-weight-bold">Latest News</h4>
                                <a class="text-secondary font-weight-medium text-decoration-none" href="">View All</a>
                            </div>
                        </div>     `;
    for (let i = 5; i <= 16; i++) {
        var date = new Date(data[i].publishedAt).toLocaleString();
        html += `
              <div class="col-lg-6">
                            <div class="position-relative mb-3">
                                <img class="img-fluid" id="img1" src="${data[i].urlToImage}" style="object-fit: cover;">
                                <div class="bg-white border border-top-0 p-4" id="main_content_text">
                                    <div class="mb-2">
                                        <a class="badge badge-primary text-uppercase font-weight-semi-bold p-2 mr-2"
                                            href="${data[i].url}">${data[i].name}</a>
                                        <a class="text-body" href=""><small>${date}</small></a>
                                    </div>
                                    <a id="title" data-toggle="tooltip" title="${data[i].title}" class="h4 d-block mb-3 text-secondary text-uppercase font-weight-bold" href="${data[i].url}">${data[i].title}</a>
                                    <p id="contenttext" class="m-0" >${data[i].content}</p>
                                </div>
                                <div class="d-flex justify-content-between bg-white border border-top-0 p-4">
                                    <div class="d-flex align-items-center" id="author">
                                        <small>${data[i].author}</small>
                                    </div>
                                    <div class="d-flex align-items-center">
                                        <small class="ml-3"><i class="far fa-eye mr-2"></i>12345</small>
                                        <small class="ml-3"><i class="far fa-comment mr-2"></i>123</small>
                                    </div>
                                </div>
                            </div>
                </div>
                `;
    }
    ;
    domSlide.innerHTML = html;
}
const renderSlide4 = (data) => {
    var domSlide = document.querySelector("#content4")
    var html = '';
    for (let i = 17; i <= 22; i++) {
        var date = new Date(data[i].publishedAt).toLocaleString();
        html += `
              <div class="d-flex align-items-center bg-white mb-3" style="height: 110px;">
                                <img class="img-fluid" id="img2" src="${data[i].urlToImage}" alt="">
                                <div class="w-100 h-100 px-3 d-flex flex-column justify-content-center border border-left-0">
                                    <div class="mb-2">
                                        <a class="badge badge-primary text-uppercase font-weight-semi-bold p-1 mr-2" href="${data[i].url}">${data[i].name}</a>
                                        <a class="text-body" href="${data[i].url}"><small>${date}</small></a>
                                    </div>
                                    <a id="author" data-toggle="tooltip" title="${data[i].title}" class="h6 m-0 text-secondary text-uppercase font-weight-bold" href="${data[i].url}">${data[i].title}</a>
                                </div>
                            </div>

                `;
    }
    ;
    domSlide.innerHTML = html;
}
const renderSlide6 = (data) => {
    var domSlide = document.querySelector("#source")
    var html = '';
    for (let i = 0; i <= 10; i++) {
        var date = new Date(data[i].publishedAt).toLocaleString();
        html += `
              <a class="btn btn-sm btn-outline-secondary m-1 text-white" href="${data[i].url}">${data[i].name}</a>
                `;
    }
    ;
    domSlide.innerHTML = html;
}
const main2 = async () => {
    var url = 'http://localhost:8083/api/category';
    var reponse = await fetch(url);
    var data= await reponse.json();
    renderSlide(data);
    renderSlide5(data);
    renderSlide7(data);
}
const renderSlide5 = (data) => {
    var domSlide = document.querySelector("#tag")
    var html = '';
    data.forEach((element,index) => {
        html+=`
          <a href="${element.categoryName}" class="btn btn-sm btn-outline-secondary m-1 text-capitalize">${element.categoryName}</a>
            `;
    });

    console.log(domSlide);
    domSlide.innerHTML=html;
}
const renderSlide = (data) => {
    var domSlide = document.querySelector("#tags")
    var html = '';
    data.forEach((element,index) => {
        html+=`
    <a href="${element.categoryName}" class="btn btn-sm btn-secondary m-1 text-capitalize">${element.categoryName}</a>
            `;
    });

    console.log(domSlide);
    domSlide.innerHTML=html;
}
const renderSlide7 = (data) => {
    var domSlide = document.querySelector("#dropdown")
    var html = '';
    data.forEach((element,index) => {
        html+=`
          <a href="${element.categoryName}" class="dropdown-item text-capitalize">${element.categoryName}</a>
            `;
    });

    console.log(domSlide);
    domSlide.innerHTML=html;
}
//business https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=23c32970b28843338178d2c1168091f7
main()
main2()