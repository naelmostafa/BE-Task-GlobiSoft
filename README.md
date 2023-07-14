# Backend APIs

**Base URL**: `http://localhost:8080/api`

## Customer APIs

**URL**: `/customer`

### Get all customers

```
GET /all
```

### Get customer by id

```
GET /{id}
```

### Create customer

```
POST /{add}
```

body:

```json
{
  "name": "string",
  "number": "string"
}
```

### Update customer

```
PUT /{update}
```

body:

```json
{
  "id": "number",
  "name": "string",
  "number": "string"
}
```

### Delete customer

```
DELETE delete/{id}
```

## Product APIs

**URL**: `/product`

### Get all products

```
GET /all
```

### Get product by id

```
GET /{id}
```

### Create product

```

POST /{add}
```

body:

```json
{
  "name": "string",
  "price": "number"
}
```

### Update product

```
PUT /{update}
```

body:

```json
{
  "id": "number",
  "name": "string",
  "price": "number"
}
```

### Delete product

```
DELETE delete/{id}
```

## Cart APIs

**URL**: `/cart`

### Get all carts

```
GET /all
```

### Get cart by customer id

```
GET /{customerId}
```

### Add product to cart

```
POST /{add}
```

body:

```json
{
  "cartItems": [
    {
      "quantity": 10,
      "product": {
        "id": 4,
        "name": "Product 4",
        "price": 400
      }
    },
    {
      "quantity": 10,
      "product": {
        "id": 3,
        "name": "Product 3",
        "price": 300
      }
    }
  ],
  "customerId": 5
}
```

## Order APIs

**URL**: `/order`

### Get all orders

```
GET /all
```

### Place order

```
POST /place-order/{customer}
```

body:

```json
{
  "id": "number",
  "name": "string",
  "number": "string"
}
```
