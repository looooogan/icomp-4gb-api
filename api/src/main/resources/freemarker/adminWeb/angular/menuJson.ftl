[
{
"text": "管理菜单",
"heading": "true",
"translate": "sidebar.heading.HEADER"
},
<#list entities? keys  as  key>
    <#assign entity=entities[key]>
{
"text": "${(entity.name)!}${(entity.comment)!}管理",
"sref": "app.${(entity.name)!}",
"icon": "icon-speedometer",
"label": "label label-info",
"translate": "sidebar.nav.${(entity.name)!}"
},
</#list>
{
"text": "Dashboard",
"sref": "#",
"icon": "icon-speedometer",
"alert": "3",
"label": "label label-info",
"submenu": [
{
"text": "Dashboard v1",
"sref": "app.dashboard"
},
{
"text": "Dashboard v2",
"sref": "app.dashboard_v2"
},
{
"text": "Dashboard v3",
"sref": "app.dashboard_v3"
}
],
"translate": "sidebar.nav.DASHBOARD"
}
]