Корневой хост
* http://localhost:8080/


# **Профессия**

кратко(** это значит /api/profession):
**: /api/employees



## GET(FindAll)

**

### _response_
[
{
"id": 1,
"title": "Секретарь",
"note": "Знаю телефоны наизусть"
},
{
"id": 2,
"title": "Секретарь",
"note": "Знаю телефоны наизусть"
}
]

## POST

**/save_profession

### _request

{
"title": "Секретарь",
"note": "Знаю телефоны наизусть"
}


### _response_
{
"id": 2,
"title": "Секретарь",
"note": "Знаю телефоны наизусть"
}

## GET(FindById)
**/{id}
### _response_
{
"id": 2,
"title": "Директор",
"note": "Знаю людей наизусть"
}


## UPDATE

**/update_profession/{id}
### _request
{
"title": "Директор",
"note": "Знаю людей наизусть"
}

### _response_
{
"id": 2,
"title": "Директор",
"note": "Знаю людей наизусть"
}

## DELETE

**/remove_profession/{id}









# _Отдел_

полный путь
http://localhost:8080/api/department/
кратко(** это значит /api/department):
**
/api/department



## GET(FindAll)

**
### _response_
[
{
"id": 1,
"title": "Отдел gbgfhf",
"note": "Занимается разработкой ПО",
"parent": null
},
{
"id": 2,
"title": "Отдел gbgfhf",
"note": "Занимается разработкой ПО",
"parent": null
}
]

## POST

**/save_department

### _request_
{
"title": "Отдел gbgfhf",
"note": "Занимается разработкой ПО",
"parent": "1"
}

### _response_
{
"id": 1,
"title": "Отдел gbgfhf",
"note": "Занимается разработкой ПО",
"parent": "1"
}

## GET(FindById)

**/{id}

### _response_
{
"id": 1,
"title": "Отдел gbgfhf",
"note": "Занимается разработкой ПО",
"parent": "1"
}

## UPDATE

**/update_department/{id}

### _request_
{
"title": "Отдел чего-то",
"note": "Занимается разработкой app",
"parent": "1"
}

### _response_
{
"id": 1,
"title": "Отдел чего-то",
"note": "Занимается разработкой app",
"parent": "1"
}


## DELETE

**/remove_department/{id}



# _Сотрудники_

кратко(** это значит /api/employees):
**: /api/employees



## GET(FindAll)

**
выводится список
[
{
"id": 1,
"profession": "Токарь",
"department": "Цех",
"note": "Аккуратный",
"fio": "Лебяжьев"
},
{
"id": 2,
"profession": "Токарь",
"department": "Цех",
"note": "hello",
"fio": "Лебяжьев"
}
]


## POST

**/save_employee

### _request_
{
"profession": "Токарь",
"department": "Цех",
"note": "Аккуратный",
"fio": "Лебяжьев"
}


### _response_
{
"id": 1,
"profession": "Токарь",
"department": "Цех",
"note": "Аккуратный",
"fio": "Лебяжьев"
}

## GET(FindById)

**/{id}

### _response_
{
"id": 1,
"profession": "Токарь",
"department": "Цех",
"note": "Аккуратный",
"fio": "Лебяжьев"
}

## UPDATE

**/update_employee/{id}

### _request_
{
"profession": "Токарь",
"department": "Цех",
"note": "Аккуратный",
"fio": "Лебяжьев"
}

### _response_
{
"id": 1,
"profession": "Токарь",
"department": "Цех",
"note": "Аккуратный",
"fio": "Лебяжьев"
}


## DELETE

**/remove_employee/{id}







