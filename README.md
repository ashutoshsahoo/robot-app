# Robot Application

- Run the application :
```sh
$ mvn spring-boot:run
```

- Check Robot battery charge :
```sh
robot:> status
```
- Charge robot battery :
```sh
robot:> charge
```

- Ask Robot to walk 3.5 km :
```sh
robot:> walk  --distance 3.5
```
- Ask Robot to walk 2 km with 3kg object :
```sh
robot:> walk  --distance 2 --weight 3
```

or 

```sh
robot:> walk 2 3
```

- Ask Robot to walk with 12kg object :
```sh
robot:> walk  --weight 12
```

- Ask Robot to scan :
```sh
robot:> scan
```
- Exit:
```sh
robot:> exit
```

- Help:
```sh
robot:> help
```
- Execute test cases :
```sh
$ mvn test
```
## Reference

- [Spring Shell](https://docs.spring.io/spring-shell/docs/current/reference/htmlsingle/)