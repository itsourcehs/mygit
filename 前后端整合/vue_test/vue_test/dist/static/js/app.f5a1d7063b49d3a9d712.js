webpackJsonp([1], {
    "+une": function(t, e) {},
    "/5OZ": function(t, e) {},
    "2C0k": function(t, e) {},
    "5r8E": function(t, e) {},
    "8SnC": function(t, e) {},
    B7Ds: function(t, e) {},
    Ep2w: function(t, e) {},
    KPOh: function(t, e) {},
    NHnr: function(t, e, a) {
      "use strict";
      Object.defineProperty(e, "__esModule", {
        value: !0
      });
      var o = a("/5sW"),
        r = {
          render: function() {
            var t = this.$createElement,
              e = this._self._c || t;
            return e("div", {
                attrs: {
                  id: "app"
                }
              },
              [e("router-view")], 1)
          },
          staticRenderFns: []
        };
      var n = a("VU/8")({
          name: "App"
        },
        r, !1,
        function(t) {
          a("z6wo")
        },
        null, null).exports,
        i = a("/ocq"),
        s = {
          render: function() {
            var t = this,
              e = t.$createElement,
              a = t._self._c || e;
            return a("div", {
                staticClass: "hello"
              },
              [a("h1", [t._v(t._s(t.msg))]), t._v(" "), a("h2", [t._v("Essential Links")]), t._v(" "), t._m(0), t._v(" "), a("h2", [t._v("Ecosystem")]), t._v(" "), t._m(1)])
          },
          staticRenderFns: [function() {
            var t = this,
              e = t.$createElement,
              a = t._self._c || e;
            return a("ul", [a("li", [a("a", {
                attrs: {
                  href: "https://vuejs.org",
                  target: "_blank"
                }
              },
              [t._v("Core Docs")])]), t._v(" "), a("li", [a("a", {
                attrs: {
                  href: "https://forum.vuejs.org",
                  target: "_blank"
                }
              },
              [t._v("Forum")])]), t._v(" "), a("li", [a("a", {
                attrs: {
                  href: "https://chat.vuejs.org",
                  target: "_blank"
                }
              },
              [t._v("Community Chat")])]), t._v(" "), a("li", [a("a", {
                attrs: {
                  href: "https://twitter.com/vuejs",
                  target: "_blank"
                }
              },
              [t._v("Twitter")])]), t._v(" "), a("br"), t._v(" "), a("li", [a("a", {
                attrs: {
                  href: "http://vuejs-templates.github.io/webpack/",
                  target: "_blank"
                }
              },
              [t._v("Docs for This Template")])])])
          },
            function() {
              var t = this.$createElement,
                e = this._self._c || t;
              return e("ul", [e("li", [e("a", {
                  attrs: {
                    href: "http://router.vuejs.org/",
                    target: "_blank"
                  }
                },
                [this._v("vue-router")])]), this._v(" "), e("li", [e("a", {
                  attrs: {
                    href: "http://vuex.vuejs.org/",
                    target: "_blank"
                  }
                },
                [this._v("vuex")])]), this._v(" "), e("li", [e("a", {
                  attrs: {
                    href: "http://vue-loader.vuejs.org/",
                    target: "_blank"
                  }
                },
                [this._v("vue-loader")])]), this._v(" "), e("li", [e("a", {
                  attrs: {
                    href: "https://github.com/vuejs/awesome-vue",
                    target: "_blank"
                  }
                },
                [this._v("awesome-vue")])])])
            }]
        };
      var l = a("VU/8")({
          name: "HelloWorld",
          data: function() {
            return {
              msg: "欢迎来到菜鸟教程！"
            }
          }
        },
        s, !1,
        function(t) {
          a("5r8E")
        },
        "data-v-139d7bbd", null).exports,
        c = {
          render: function() {
            var t = this.$createElement;
            return (this._self._c || t)("div")
          },
          staticRenderFns: []
        };
      var u = a("VU/8")({
          name: "AppIndex"
        },
        c, !1,
        function(t) {
          a("nlAs")
        },
        "data-v-7b73ad80", null).exports,
        m = {
          name: "Login",
          data: function() {
            return {
              loginForm: {
                username: "admin",
                password: "123456"
              },
              responseResult: []
            }
          },
          methods: {
            login: function() {
              var t = this,
                e = this;
              console.log(this.$store.state),
                this.$axios.post("/login", {
                  username: this.loginForm.username,
                  password: this.loginForm.password
                }).then(function(a) {
                  if (200 === a.data.code) {
                    e.$store.commit("login", e.loginForm);
                    var o = t.$route.query.redirect;
                    t.$router.replace({
                      path: "/" === o || void 0 === o ? "/index": o
                    })
                  }
                }).
                catch(function(t) {})
            }
          }
        },
        d = {
          render: function() {
            var t = this,
              e = t.$createElement,
              a = t._self._c || e;
            return a("el-form", {
                staticClass: "login-container",
                attrs: {
                  "label-position": "left",
                  "label-width": "0px"
                }
              },
              [a("h3", {
                  staticClass: "login_title"
                },
                [t._v("系统登录")]), t._v(" "), a("el-form-item", [a("el-input", {
                attrs: {
                  type: "text",
                  "auto-complete": "off",
                  placeholder: "账号"
                },
                model: {
                  value: t.loginForm.username,
                  callback: function(e) {
                    t.$set(t.loginForm, "username", e)
                  },
                  expression: "loginForm.username"
                }
              }), t._v(" "), a("br"), a("br")], 1), t._v(" "), a("el-form-item", [a("el-input", {
                attrs: {
                  type: "password",
                  "auto-complete": "off",
                  placeholder: "密码"
                },
                model: {
                  value: t.loginForm.password,
                  callback: function(e) {
                    t.$set(t.loginForm, "password", e)
                  },
                  expression: "loginForm.password"
                }
              }), t._v(" "), a("br"), a("br")], 1), t._v(" "), a("el-form-item", {
                  staticStyle: {
                    width: "100%"
                  }
                },
                [a("el-button", {
                    staticStyle: {
                      width: "100%",
                      background: "#505458",
                      border: "none"
                    },
                    attrs: {
                      type: "primary"
                    },
                    on: {
                      click: t.login
                    }
                  },
                  [t._v("登录")])], 1)], 1)
          },
          staticRenderFns: []
        };
      var f = a("VU/8")(m, d, !1,
        function(t) {
          a("2C0k")
        },
        null, null).exports,
        v = {
          render: function() {
            var t = this,
              e = t.$createElement,
              a = t._self._c || e;
            return a("el-menu", {
                staticStyle: {
                  "min-width": "1300px"
                },
                attrs: {
                  "default-active": "/index",
                  router: "",
                  mode: "horizontal",
                  "background-color": "white",
                  "text-color": "#222",
                  "active-text-color": "red"
                }
              },
              [t._l(t.navList,
                function(e, o) {
                  return a("el-menu-item", {
                      key: o,
                      attrs: {
                        index: e.name
                      }
                    },
                    [t._v(t._s(e.navItem))])
                }), t._v(" "), a("a", {
                  staticStyle: {
                    color: "#222",
                    float: "right",
                    padding: "20px"
                  },
                  attrs: {
                    href: "#nowhere"
                  }
                },
                [t._v("更多功能")]), t._v(" "), a("i", {
                staticClass: "el-icon-menu",
                staticStyle: {
                  float: "right",
                  "font-size": "45px",
                  color: "#222",
                  "padding-top": "8px"
                }
              }), t._v(" "), a("span", {
                  staticStyle: {
                    position: "absolute",
                    "padding-top": "20px",
                    right: "43%",
                    "font-size": "20px",
                    "font-weight": "bold"
                  }
                },
                [t._v("White Jotter - Your Mind Palace")])], 2)
          },
          staticRenderFns: []
        };
      var p = {
          name: "Home",
          components: {
            NavMenu: a("VU/8")({
                name: "NavMenu",
                data: function() {
                  return {
                    navList: [{
                      name: "/index",
                      navItem: "首页"
                    },
                      {
                        name: "/jotter",
                        navItem: "笔记本"
                      },
                      {
                        name: "/library",
                        navItem: "图书馆"
                      },
                      {
                        name: "/admin",
                        navItem: "个人中心"
                      }]
                  }
                }
              },
              v, !1,
              function(t) {
                a("/5OZ")
              },
              "data-v-368db485", null).exports
          }
        },
        h = {
          render: function() {
            var t = this.$createElement,
              e = this._self._c || t;
            return e("div", [e("nav-menu"), this._v(" "), e("router-view")], 1)
          },
          staticRenderFns: []
        };
      var _ = a("VU/8")(p, h, !1,
        function(t) {
          a("B7Ds")
        },
        null, null).exports,
        b = {
          render: function() {
            var t = this,
              e = t.$createElement,
              a = t._self._c || e;
            return a("el-menu", {
                staticClass: "categories",
                attrs: {
                  "default-active": "0",
                  "active-text-color": "red"
                },
                on: {
                  select: t.handleSelect
                }
              },
              [a("el-menu-item", {
                  attrs: {
                    index: "0"
                  }
                },
                [a("i", {
                  staticClass: "el-icon-menu"
                }), t._v(" "), a("span", {
                    attrs: {
                      slot: "title"
                    },
                    slot: "title"
                  },
                  [t._v("全部")])]), t._v(" "), a("el-menu-item", {
                  attrs: {
                    index: "1"
                  }
                },
                [a("i", {
                  staticClass: "el-icon-menu"
                }), t._v(" "), a("span", {
                    attrs: {
                      slot: "title"
                    },
                    slot: "title"
                  },
                  [t._v("文学")])]), t._v(" "), a("el-menu-item", {
                  attrs: {
                    index: "2"
                  }
                },
                [a("i", {
                  staticClass: "el-icon-menu"
                }), t._v(" "), a("span", {
                    attrs: {
                      slot: "title"
                    },
                    slot: "title"
                  },
                  [t._v("流行")])]), t._v(" "), a("el-menu-item", {
                  attrs: {
                    index: "3"
                  }
                },
                [a("i", {
                  staticClass: "el-icon-menu"
                }), t._v(" "), a("span", {
                    attrs: {
                      slot: "title"
                    },
                    slot: "title"
                  },
                  [t._v("文化")])]), t._v(" "), a("el-menu-item", {
                  attrs: {
                    index: "4"
                  }
                },
                [a("i", {
                  staticClass: "el-icon-menu"
                }), t._v(" "), a("span", {
                    attrs: {
                      slot: "title"
                    },
                    slot: "title"
                  },
                  [t._v("生活")])]), t._v(" "), a("el-menu-item", {
                  attrs: {
                    index: "5"
                  }
                },
                [a("i", {
                  staticClass: "el-icon-menu"
                }), t._v(" "), a("span", {
                    attrs: {
                      slot: "title"
                    },
                    slot: "title"
                  },
                  [t._v("经管")])]), t._v(" "), a("el-menu-item", {
                  attrs: {
                    index: "6"
                  }
                },
                [a("i", {
                  staticClass: "el-icon-menu"
                }), t._v(" "), a("span", {
                    attrs: {
                      slot: "title"
                    },
                    slot: "title"
                  },
                  [t._v("科技")])])], 1)
          },
          staticRenderFns: []
        };
      var g = a("VU/8")({
          name: "SideMenu",
          data: function() {
            return {
              cid: ""
            }
          },
          methods: {
            handleSelect: function(t) {
              this.cid = t,
                this.$emit("indexSelect")
            }
          }
        },
        b, !1,
        function(t) {
          a("mZ+I")
        },
        "data-v-8f8699bc", null).exports,
        x = {
          render: function() {
            var t = this,
              e = t.$createElement,
              a = t._self._c || e;
            return a("div", [a("i", {
              staticClass: "el-icon-circle-plus-outline",
              on: {
                click: function(e) {
                  t.dialogFormVisible = !0
                }
              }
            }), t._v(" "), a("el-dialog", {
                attrs: {
                  title: "添加/修改图书",
                  visible: t.dialogFormVisible
                },
                on: {
                  "update:visible": function(e) {
                    t.dialogFormVisible = e
                  },
                  close: t.clear
                }
              },
              [a("el-form", {
                  ref: "dataForm",
                  staticStyle: {
                    "text-align": "left"
                  },
                  model: {
                    value: t.form,
                    callback: function(e) {
                      t.form = e
                    },
                    expression: "form"
                  }
                },
                [a("el-form-item", {
                    attrs: {
                      label: "书名",
                      "label-width": t.formLabelWidth,
                      prop: "title"
                    }
                  },
                  [a("el-input", {
                    attrs: {
                      autocomplete: "off",
                      placeholder: "不加 《》"
                    },
                    model: {
                      value: t.form.title,
                      callback: function(e) {
                        t.$set(t.form, "title", e)
                      },
                      expression: "form.title"
                    }
                  })], 1), t._v(" "), a("el-form-item", {
                    attrs: {
                      label: "作者",
                      "label-width": t.formLabelWidth,
                      prop: "author"
                    }
                  },
                  [a("el-input", {
                    attrs: {
                      autocomplete: "off"
                    },
                    model: {
                      value: t.form.author,
                      callback: function(e) {
                        t.$set(t.form, "author", e)
                      },
                      expression: "form.author"
                    }
                  })], 1), t._v(" "), a("el-form-item", {
                    attrs: {
                      label: "出版日期",
                      "label-width": t.formLabelWidth,
                      prop: "date"
                    }
                  },
                  [a("el-input", {
                    attrs: {
                      autocomplete: "off"
                    },
                    model: {
                      value: t.form.date,
                      callback: function(e) {
                        t.$set(t.form, "date", e)
                      },
                      expression: "form.date"
                    }
                  })], 1), t._v(" "), a("el-form-item", {
                    attrs: {
                      label: "出版社",
                      "label-width": t.formLabelWidth,
                      prop: "press"
                    }
                  },
                  [a("el-input", {
                    attrs: {
                      autocomplete: "off"
                    },
                    model: {
                      value: t.form.press,
                      callback: function(e) {
                        t.$set(t.form, "press", e)
                      },
                      expression: "form.press"
                    }
                  })], 1), t._v(" "), a("el-form-item", {
                    attrs: {
                      label: "封面",
                      "label-width": t.formLabelWidth,
                      prop: "cover"
                    }
                  },
                  [a("el-input", {
                    attrs: {
                      autocomplete: "off",
                      placeholder: "图片 URL"
                    },
                    model: {
                      value: t.form.cover,
                      callback: function(e) {
                        t.$set(t.form, "cover", e)
                      },
                      expression: "form.cover"
                    }
                  })], 1), t._v(" "), a("el-form-item", {
                    attrs: {
                      label: "简介",
                      "label-width": t.formLabelWidth,
                      prop: "abs"
                    }
                  },
                  [a("el-input", {
                    attrs: {
                      type: "textarea",
                      autocomplete: "off"
                    },
                    model: {
                      value: t.form.abs,
                      callback: function(e) {
                        t.$set(t.form, "abs", e)
                      },
                      expression: "form.abs"
                    }
                  })], 1), t._v(" "), a("el-form-item", {
                    attrs: {
                      label: "分类",
                      "label-width": t.formLabelWidth,
                      prop: "cid"
                    }
                  },
                  [a("el-select", {
                      attrs: {
                        placeholder: "请选择分类"
                      },
                      model: {
                        value: t.form.category.id,
                        callback: function(e) {
                          t.$set(t.form.category, "id", e)
                        },
                        expression: "form.category.id"
                      }
                    },
                    [a("el-option", {
                      attrs: {
                        label: "文学",
                        value: "1"
                      }
                    }), t._v(" "), a("el-option", {
                      attrs: {
                        label: "流行",
                        value: "2"
                      }
                    }), t._v(" "), a("el-option", {
                      attrs: {
                        label: "文化",
                        value: "3"
                      }
                    }), t._v(" "), a("el-option", {
                      attrs: {
                        label: "生活",
                        value: "4"
                      }
                    }), t._v(" "), a("el-option", {
                      attrs: {
                        label: "经管",
                        value: "5"
                      }
                    }), t._v(" "), a("el-option", {
                      attrs: {
                        label: "科技",
                        value: "6"
                      }
                    })], 1)], 1), t._v(" "), a("el-form-item", {
                    staticStyle: {
                      height: "0"
                    },
                    attrs: {
                      prop: "id"
                    }
                  },
                  [a("el-input", {
                    attrs: {
                      type: "hidden",
                      autocomplete: "off"
                    },
                    model: {
                      value: t.form.id,
                      callback: function(e) {
                        t.$set(t.form, "id", e)
                      },
                      expression: "form.id"
                    }
                  })], 1)], 1), t._v(" "), a("div", {
                  staticClass: "dialog-footer",
                  attrs: {
                    slot: "footer"
                  },
                  slot: "footer"
                },
                [a("el-button", {
                    on: {
                      click: function(e) {
                        t.dialogFormVisible = !1
                      }
                    }
                  },
                  [t._v("取消")]), t._v(" "), a("el-button", {
                    attrs: {
                      type: "primary"
                    },
                    on: {
                      click: t.onSubmit
                    }
                  },
                  [t._v("确定")])], 1)], 1)], 1)
          },
          staticRenderFns: []
        };
      var k = {
        render: function() {
          var t = this,
            e = t.$createElement,
            a = t._self._c || e;
          return a("div", {
              staticStyle: {
                "margin-bottom": "30px",
                display: "flex",
                "justify-content": "center",
                "align-items": "center"
              }
            },
            [a("el-input", {
              staticStyle: {
                width: "400px",
                "margin-right": "10px"
              },
              attrs: {
                placeholder: "通过书名或作者搜索",
                "prefix-icon": "el-icon-search",
                size: "small"
              },
              nativeOn: {
                keyup: function(e) {
                  return ! e.type.indexOf("key") && t._k(e.keyCode, "enter", 13, e.key, "Enter") ? null: t.searchClick.apply(null, arguments)
                }
              },
              model: {
                value: t.keywords,
                callback: function(e) {
                  t.keywords = e
                },
                expression: "keywords"
              }
            }), t._v(" "), a("el-button", {
                attrs: {
                  size: "small",
                  type: "primary",
                  icon: "el-icon-search"
                },
                on: {
                  click: t.searchClick
                }
              },
              [t._v("搜索")])], 1)
        },
        staticRenderFns: []
      };
      var y = {
        render: function() {
          var t = this,
            e = t.$createElement;
          return (t._self._c || e)("el-switch", {
            attrs: {
              "active-text": "列表视图"
            },
            model: {
              value: t.value,
              callback: function(e) {
                t.value = e
              },
              expression: "value"
            }
          })
        },
        staticRenderFns: []
      };
      var w = {
          name: "Books",
          components: {
            EditForm: a("VU/8")({
                name: "EditForm",
                data: function() {
                  return {
                    dialogFormVisible: !1,
                    form: {
                      id: "",
                      title: "",
                      author: "",
                      date: "",
                      press: "",
                      cover: "",
                      abs: "",
                      category: {
                        id: "",
                        name: ""
                      }
                    },
                    formLabelWidth: "120px"
                  }
                },
                methods: {
                  clear: function() {
                    this.form = {
                      id: "",
                      title: "",
                      author: "",
                      date: "",
                      press: "",
                      cover: "",
                      abs: "",
                      category: {
                        id: "",
                        name: ""
                      }
                    }
                  },
                  onSubmit: function() {
                    var t = this;
                    this.$axios.post("/books", {
                      id: this.form.id,
                      cover: this.form.cover,
                      title: this.form.title,
                      author: this.form.author,
                      date: this.form.date,
                      press: this.form.press,
                      abs: this.form.abs,
                      category: this.form.category
                    }).then(function(e) {
                      e && 200 === e.status && (t.dialogFormVisible = !1, t.$emit("onSubmit"))
                    })
                  }
                }
              },
              x, !1,
              function(t) {
                a("8SnC")
              },
              "data-v-5e92ab94", null).exports,
            SearchBar: a("VU/8")({
                name: "SearchBar",
                data: function() {
                  return {
                    keywords: "",
                    books: [],
                    cardLoading: []
                  }
                },
                methods: {
                  searchClick: function() {
                    this.$emit("onSearch")
                  }
                }
              },
              k, !1,
              function(t) {
                a("PtMP")
              },
              "data-v-898b77b0", null).exports,
            ViewSwitch: a("VU/8")({
                name: "ViewSwitch",
                data: function() {
                  return {
                    value: !0
                  }
                }
              },
              y, !1,
              function(t) {
                a("+une")
              },
              "data-v-28458f86", null).exports
          },
          data: function() {
            return {
              books: [],
              currentPage: 1,
              pagesize: 17
            }
          },
          mounted: function() {
            this.loadBooks()
          },
          methods: {
            loadBooks: function() {
              var t = this;
              this.$axios.get("/books").then(function(e) {
                e && 200 === e.status && (t.books = e.data)
              })
            },
            searchResult: function() {
              var t = this;
              this.$axios.get("/search?keywords=" + this.$refs.searchBar.keywords, {}).then(function(e) {
                e && 200 === e.status && (t.books = e.data)
              })
            },
            handleCurrentChange: function(t) {
              this.currentPage = t,
                console.log(this.currentPage)
            },
            editBook: function(t) {
              this.$refs.edit.dialogFormVisible = !0,
                this.$refs.edit.form = {
                  id: t.id,
                  cover: t.cover,
                  title: t.title,
                  author: t.author,
                  date: t.date,
                  press: t.press,
                  abs: t.abs,
                  category: {
                    id: t.category.id.toString(),
                    name: t.category.name
                  }
                }
            },
            deleteBook: function(t) {
              var e = this;
              this.$confirm("此操作将永久删除该书籍, 是否继续?", "提示", {
                confirmButtonText: "确定",
                cancelButtonText: "取消",
                type: "warning"
              }).then(function() {
                e.$axios.post("/delete", {
                  id: t
                }).then(function(t) {
                  t && 200 === t.status && e.loadBooks()
                })
              }).
              catch(function() {
                e.$message({
                  type: "info",
                  message: "已取消删除"
                })
              })
            }
          }
        },
        $ = {
          render: function() {
            var t = this,
              e = t.$createElement,
              a = t._self._c || e;
            return a("div", [a("el-row", {
                staticStyle: {
                  height: "840px"
                }
              },
              [a("search-bar", {
                ref: "searchBar",
                on: {
                  onSearch: t.searchResult
                }
              }), t._v(" "), a("view-switch", {
                staticClass: "switch"
              }), t._v(" "), t._l(t.books.slice((t.currentPage - 1) * t.pagesize, t.currentPage * t.pagesize),
                function(e) {
                  return a("el-tooltip", {
                      key: e.id,
                      attrs: {
                        effect: "dark",
                        placement: "right"
                      }
                    },
                    [a("p", {
                        staticStyle: {
                          "font-size": "14px",
                          "margin-bottom": "6px"
                        },
                        attrs: {
                          slot: "content"
                        },
                        slot: "content"
                      },
                      [t._v(t._s(e.title))]), t._v(" "), a("p", {
                        staticStyle: {
                          "font-size": "13px",
                          "margin-bottom": "6px"
                        },
                        attrs: {
                          slot: "content"
                        },
                        slot: "content"
                      },
                      [a("span", [t._v(t._s(e.author))]), t._v(" "), a("span", [t._v(t._s(e.date))]), t._v(" "), a("span", [t._v(t._s(e.press))])]), t._v(" "), a("p", {
                        staticClass: "abstract",
                        staticStyle: {
                          width: "300px"
                        },
                        attrs: {
                          slot: "content"
                        },
                        slot: "content"
                      },
                      [t._v(t._s(e.abs))]), t._v(" "), a("el-card", {
                        staticClass: "book",
                        staticStyle: {
                          width: "135px",
                          "margin-bottom": "20px",
                          height: "233px",
                          float: "left",
                          "margin-right": "15px"
                        },
                        attrs: {
                          bodyStyle: "padding:10px",
                          shadow: "hover"
                        }
                      },
                      [a("div", {
                          staticClass: "cover",
                          on: {
                            click: function(a) {
                              return t.editBook(e)
                            }
                          }
                        },
                        [a("img", {
                          attrs: {
                            src: e.cover,
                            alt: "封面"
                          }
                        })]), t._v(" "), a("div", {
                          staticClass: "info"
                        },
                        [a("div", {
                            staticClass: "title"
                          },
                          [a("a", {
                              attrs: {
                                href: ""
                              }
                            },
                            [t._v(t._s(e.title))])]), t._v(" "), a("i", {
                          staticClass: "el-icon-delete",
                          on: {
                            click: function(a) {
                              return t.deleteBook(e.id)
                            }
                          }
                        })]), t._v(" "), a("div", {
                          staticClass: "author"
                        },
                        [t._v(t._s(e.author))])])], 1)
                }), t._v(" "), a("edit-form", {
                ref: "edit",
                on: {
                  onSubmit: function(e) {
                    return t.loadBooks()
                  }
                }
              })], 2), t._v(" "), a("el-row", [a("el-pagination", {
              attrs: {
                "current-page": t.currentPage,
                "page-size": t.pagesize,
                total: t.books.length
              },
              on: {
                "current-change": t.handleCurrentChange
              }
            })], 1)], 1)
          },
          staticRenderFns: []
        };
      var S = {
          name: "AppLibrary",
          components: {
            Books: a("VU/8")(w, $, !1,
              function(t) {
                a("Ep2w")
              },
              "data-v-38cdcbad", null).exports,
            SideMenu: g
          },
          methods: {
            listByCategory: function() {
              var t = this,
                e = "categories/" + this.$refs.sideMenu.cid + "/books";
              this.$axios.get(e).then(function(e) {
                e && 200 === e.data.code && (t.$refs.booksArea.books = e.data)
              })
            }
          }
        },
        C = {
          render: function() {
            var t = this.$createElement,
              e = this._self._c || t;
            return e("el-container", [e("el-aside", {
                staticStyle: {
                  width: "200px",
                  "margin-top": "20px"
                }
              },
              [e("switch"), this._v(" "), e("SideMenu", {
                ref: "sideMenu",
                on: {
                  indexSelect: this.listByCategory
                }
              })], 1), this._v(" "), e("el-main", [e("books", {
              ref: "booksArea",
              staticClass: "books-area"
            })], 1)], 1)
          },
          staticRenderFns: []
        };
      var F = a("VU/8")(S, C, !1,
        function(t) {
          a("KPOh")
        },
        "data-v-ea909442", null).exports;
      o.
      default.use(i.a);
      var E = new i.a({
          mode: "history",
          routes: [{
            path: "/home",
            name: "Home",
            component: _,
            redirect: "/index",
            children: [{
              path: "/index",
              name: "AppIndex",
              component: u,
              meta: {
                requireAuth: !0
              }
            },
              {
                path: "/library",
                name: "Library",
                component: F,
                meta: {
                  requireAuth: !0
                }
              }]
          },
            {
              path: "/login",
              name: "Login",
              component: f
            },
            {
              path: "/",
              name: "HelloWorld",
              component: l
            }]
        }),
        V = a("zL8q"),
        B = a.n(V),
        L = (a("tvR6"), a("mvHQ")),
        R = a.n(L),
        z = a("NYxO");
      o.
      default.use(z.a);
      var P = new z.a.Store({
          state: {
            user: {
              username: null == window.localStorage.getItem("user") ? "": JSON.parse(window.localStorage.getItem("user")).username
            }
          },
          mutations: {
            login: function(t, e) {
              t.user = e,
                window.localStorage.setItem("user", R()(e))
            }
          }
        }),
        U = a("mtWM");
      U.defaults.baseURL = "http://localhost:8443/api",
        o.
          default.prototype.$axios = U,
        o.
          default.config.productionTip = !1,
        o.
        default.use(B.a),
        E.beforeEach(function(t, e, a) {
          t.meta.requireAuth ? P.state.user.username ? a() : a({
            path: "login",
            query: {
              redirect: t.fullPath
            }
          }) : a()
        }),
        new o.
        default({
          el:
            "#app",
          router: E,
          store: P,
          render: function(t) {
            return t(n)
          },
          components: {
            App: n
          },
          template: "<App/>"
        })
    },
    PtMP: function(t, e) {},
    "mZ+I": function(t, e) {},
    nlAs: function(t, e) {},
    tvR6: function(t, e) {},
    z6wo: function(t, e) {}
  },
  ["NHnr"]);
//# sourceMappingURL=app.f5a1d7063b49d3a9d712.js.map
