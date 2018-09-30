# Robot Application

- Run the application :
```sh
$ mvn spring-boot:run
```

- Check Robot battery charge :
```sh
shell:> status
```
- Charge robot battery :
```sh
shell:> charge
```

- Ask Robot to walk 3.5 km :
```sh
shell:> walk  --distance 3.5
```
- Ask Robot to walk 2 km with 3kg object :
```sh
shell:> walk  --distance 2 --weight 3
```

- Ask Robot to walk with 12kg object :
```sh
shell:> walk  --weight 12
```

- Ask Robot to scan :
```sh
shell:> scan
```
- Exit:
```sh
shell:> exit
```

- Help:
```sh
shell:> help
```

##Reference

- [Spring Shell](https://docs.spring.io/spring-shell/docs/current/reference/htmlsingle/)