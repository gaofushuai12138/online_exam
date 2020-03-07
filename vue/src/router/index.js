import Vue from 'vue'
import Router from 'vue-router'
// in development env not use Lazy Loading,because Lazy Loading too many pages will cause webpack hot update too slow.so only in production use Lazy Loading
/* layout */
import Layout from '../views/layout/Layout'

const _import = require('./_import_' + process.env.NODE_ENV)
Vue.use(Router)
export const constantRouterMap = [
  {path: '/login', component: _import('login/index'), hidden: true},
  {path: '/404', component: _import('404'), hidden: true},
  {
    path: '/',
    component: Layout,
    redirect: '/dashboard',
    name: '首页',
    hidden: true,
    children: [{
      path: 'dashboard', component: _import('dashboard/index')
    }]
  }
]
export default new Router({
  // mode: 'history', //后端支持可开
  scrollBehavior: () => ({y: 0}),
  routes: constantRouterMap
})
export const asyncRouterMap = [
  // {
  //   path: '/system',
  //   component: Layout,
  //   redirect: '/system/article',
  //   name: '功能模块',
  //   meta: {title: '功能模块', icon: 'tree'},
  //   children: [
  //     {
  //       path: 'article',
  //       name: '文章',
  //       component: _import('article/article'),
  //       meta: {title: '文章', icon: 'example'},
  //       menu: 'article'
  //     },
  //   ]
  // },
  {
    path: '/user',
    component: Layout,
    redirect: '/user/',
    name: '',
    meta: {title: '用户管理', icon: 'table'},
    children: [
      {
        path: '', name: '用户列表', component: _import('user/user'), meta: {title: '用户列表', icon: 'user'}, menu: 'user'
      },
      {
        path: 'role',
        name: '权限管理',
        component: _import('user/role'),
        meta: {title: '权限管理', icon: 'password'},
        menu: 'role'
      },
    ]
  },
  {
    path:"/department",
    component:Layout,
    redirect:"sys/department",
    meta:{title:"专业管理",icon:"example"},
    children:[
      {
        path:"",name:"专业管理",component:_import('department/department'),meta:{title:"专业管理",icon:"example"},menu:"department"
      }
    ]
  },
  {
    path:"/subject",
    component:Layout,
    redirect:"sys/subject",
    meta:{title:"学科管理",icon:"example"},
    children:[
      {
        path:"course",name:"课程管理",component:_import('subject/subject'),meta:{title:"课程管理",icon:"example"},menu:"subject"
      },
      {
        path:"knowledge",name:"章节管理",component:_import('subject/knowledge'),meta:{title:"章节管理",icon:"example"}
      }
    ]
  },
  {
    path:"/question",
    component:Layout,
    redirect:"/sys/question",
    meta:{title:"题库管理",icon:"example"},
    children:[
      {
        path:"single",name:"选择题管理",component:_import('question/singleProblem'),meta:{title:"选择题管理",icon:"example"}
      },
      {
        path:"judge",name:"判断题管理",component:_import('question/JudgeProblem'),meta:{title:"判断题管理",icon:"example"}
      },
      {
        path:"subjective",name:"主观题管理",component:_import('question/subjectiveProblem'),meta:{title:"主观题管理",icon:"example"}
      }
    ]

  },
  {
    path:"/log",
    component:Layout,
    redirect:"/sys/log",
    name:"",
    meta:{title:"日志管理",icon:"example"},
    children:[
      {
        path:"",name:"日志管理",component:_import('log/log'),meta:{title:"日志管理",icon:"example"},menu:"log"
      }
    ]
  },
  {
    path:"/test",
    component:Layout,
    redirect:"/test/",
    name:"",
    meta:{title:"测试",icon:"test"},
    children:[
      {
        path:"",name:"测试",component:_import('test/test'),meta:{title:"测试",icon:"example"},menu:"role"
        
      }
    ]

  },
  {path: '*', redirect: '/404', hidden: true}
]
