$(document).ready(function () {
    $('[data-toggle="tooltip"]').tooltip();
});
let today = new Date().toDateString();
document.getElementById("date").innerHTML = today;
const main = async () => {
    var categoryKey = [[${categoryKey}]];
    var url = 'http://localhost:8083/api/article/'+categoryKey;
    var reponse = await fetch(url);
    var data = await reponse.json();
    renderSlide3(data);
}

const renderSlide3 = (data) => {
    var domSlide = document.querySelector("#content3");
    var categoryKey = [[${categoryKey}]];
    var html = '';
    html += `
             <div class="col-12">
                            <div class="section-title">
                                <h4 class="m-0 text-uppercase font-weight-bold">${categoryKey}</h4>
                             </div>
                        </div>     `;
    data.forEach((element,index) => {
        var date = new Date(element.publishedAt).toLocaleString();
        html += `
      <div class="col-lg-6">
                    <div class="position-relative mb-3">
                        <img class="img-fluid" id="img1" src="${element.urlToImage}" style="object-fit: cover;">
                        <div class="bg-white border border-top-0 p-4" id="main_content_text">
                            <div class="mb-2">
                                <a class="badge badge-primary text-uppercase font-weight-semi-bold p-2 mr-2"
                                    href="${element.url}">${element.name}</a>
                                <a class="text-body" href=""><small>${date}</small></a>
                            </div>
                            <a id="title" data-toggle="tooltip" title="${element.title}" class="h4 d-block mb-3 text-secondary text-uppercase font-weight-bold" href="${element.url}">${element.title}</a>
                            <p id="contenttext" class="m-0" >${element.content}</p>
                        </div>
                        <div class="d-flex justify-content-between bg-white border border-top-0 p-4">
                            <div class="d-flex align-items-center" id="author">
                                <small>${element.author}</small>
                            </div>
                            <div class="d-flex align-items-center">
                                <small class="ml-3"><i class="far fa-eye mr-2"></i>12345</small>
                                <small class="ml-3"><i class="far fa-comment mr-2"></i>123</small>
                            </div>
                        </div>
                    </div>
        </div>
        `;
    });

    console.log(domSlide);
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