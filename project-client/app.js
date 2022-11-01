// 以 Express 建立 Web 伺服器
var express = require("express");
var app = express();

// 安裝npm install http-proxy-middleware 協助進行代理轉發的套件
var proxy = require("http-proxy-middleware").createProxyMiddleware;

// app.use('/', proxy('http://localhost:8080'));
// app.use('/', proxy(["!**.html"], { target: 'http://localhost:8080' }));
app.use('/', proxy(['/views/**','/logout/**','/login/**','/viwes/**'], { target: 'http://localhost:8080' }));

// 允許跨域使用本服務
// var cors = require("cors");
// app.use(cors());

// Web 伺服器的靜態檔案置於 public 資料夾
app.use(express.static("public"));

// 以 body-parser 模組協助 Express 解析表單與JSON資料
var bodyParser = require('body-parser');
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));




// port號聽3000。
app.listen(3000);
console.log("Web伺服器就緒，開始接受用戶端連線.");
console.log("鍵盤「Ctrl + C」可結束伺服器程式.");