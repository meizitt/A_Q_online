import Vue from 'vue'
import axios from 'axios'

const vue = new Vue
Vue.config.devtools = true
axios.defaults.timeout = 5000; // 默认5s超时
// let baseURL = 'http://neverth.fun:8111/';
//
// let baseURL1 = 'http://neverth.fun:8080/';
let baseURL2 = 'http://localhost:8080';

Vue.prototype.$axios = axios
// Vue.config.productionTip = false


function fetch(baseurl,url,obj) {
  return new Promise((resolve, reject) => {
    axios(baseurl + url,obj )
      .then(response => {
        resolve(response.data)
      }, err => {
        Notify({ type: 'warning', message: '网络错误' });
        Toast.loading({
          message: '加载中...',
        });
        reject(err)
      })
      .catch((error => {
        reject(error)
      }))
  })
}

// function fetchPost(url, param) {
//   return(fetch(baseURL1,url,{
//     data: param,
//     method: 'post',
//     headers: { 'Content-Type': 'application/json' }
//   }))
// }
function fetchPost1(url, param) {
  return(fetch(baseURL2,url,{
    data: param,
    method: 'post',
    headers: { 'Content-Type': 'application/json' }
  }))
}
// function fetchGet(url, param) {
//   return (fetch(baseURL1,url,{
//     params: param,
//     method:'get'
//   }))
// }
function fetchGet1(url, param) {
  return (fetch(baseURL2,url,{
    params: param,
    method:'get'
  }))
}
// function fetchDelete(url,param){
//   return (fetch(baseURL2,url,{
//     data: param,
//     method:'delete',
//     headers: { 'Content-Type': 'application/json' }
//   }))
// }
// export function fetchGet(url,param){
// return fetch('get',url,param)
// }


// export function addcollection(fn, param, fn1 = () => { }) {
//   return fetchPost1('product/Like/addProductLike', param).then(fn).catch(fn1)
// }

export function canclecollect(fn, param) {
  return fetchPost1('Express/collect/cancelExpressCollect', param).then(fn)
}
export function querycollectexpressbyid(fn, id) {
  return fetchGet1(`Express/collect/getCollectByUserId/${id}`).then(fn)
}
export function getstu(fn){
  return  fetchGet1('/stu/findAll').then(fn)
}

export function register_s(fn,parma){
  return fetchPost1('/stu/add',parma).then(fn)
}
export function register_t(fn,parma){
  return fetchPost1('/tch/add',parma).then(fn)
}
export function login_s(fn,parma){
  return fetchPost1('/stu/login',parma).then(fn)
}
export function login_t(fn,parma){
  return fetchPost1('/tch/login',parma).then(fn)
}
export function getAllQ(fn,parma){
  return fetchGet1('/labq/findAll',parma).then(fn)
}
export function addQuestion(fn,parma){
  return fetchPost1('/labq/add',parma).then(fn)
}
export function updateQuestion(fn,parma){
  return fetchPost1('/labq/update',parma).then(fn)
}
export function deleteQues(fn,id){
  return fetchGet1(`/labq/del/${id}`).then(fn)
}
export function findQById(fn,id){
  return fetchGet1(`/labq/${id}`).then(fn)
}
export function findQBytext(fn,text){
  return fetchGet1('/labq/findByText/'+text).then(fn)
}
export function updateAnswer(fn,parma){
  return fetchPost1('/labq/updateAnswer',parma).then(fn)
}
export function findComm(fn,text){
  return fetchGet1('/commq/findByText/'+text).then(fn)
}





