### 获取code

#### URL: GET /oauth/authorize

**请求参数：**

- response_type=code
- client_id=blog
- state=customParam
- redirect_uri=http://localhost/code

**示例：**

http://localhost/oauth/authorize?response_type=code&client_id=tonr&state=customParam&redirect_uri=http://localhost/code

### 获取token

#### URL: POST /oauth/token

**请求参数：**
- 授权码模式
```
POST /oauth/token HTTP/1.1
Host: localhost
Content-Type: application/x-www-form-urlencoded
Cookie:  JSESSIONID=47E2D86E8864D28497F36CEF2E739F8A; _gat=1; _ga=GA1.1.1886655617.1499869098; _gid=GA1.1.1791353267.1504336943
Authorization: Basic Y2xpZW50OjEyMzQ1Ng==
Cache-Control: no-cache
Postman-Token: 6f482297-5a10-a0cf-9ce2-588f3a91aac1

grant_type=authorization_code&client_id=client&grant_type=authorization_code&code=Nw5HWz&redirect_uri=http%3A%2F%2Flocalhost%2Fcode
```
- 客户端模式
```
POST /oauth/token HTTP/1.1
Host: localhost
Content-Type: application/x-www-form-urlencoded
Cookie:  JSESSIONID=47E2D86E8864D28497F36CEF2E739F8A; _gat=1; _ga=GA1.1.1886655617.1499869098; _gid=GA1.1.1791353267.1504336943
Authorization: Basic Y2xpZW50OjEyMzQ1Ng==
Cache-Control: no-cache
Postman-Token: 31ce251c-a3cc-bc3d-7378-8a2bf92a92d4

grant_type=client_credentials
```