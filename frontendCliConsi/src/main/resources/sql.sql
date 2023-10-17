> Crear SP para consultar (Ambas tablas)
create or replace function selectclientes()
    returns table(clienteid integer, clienteactivo bool, clientenombre varchar, clientefechacreacion timestamptz, clientefechamodificacion timestamptz)
    as $$
begin
return query
select c.clienteid, c.clienteactivo, c.clientenombre, c.clientefechacreacion, c.clientefechamodificacion from cliente c order by clientefechamodificacion desc limit 5;
end;
$$ language plpgsql;

create or replace function selectconsignatario()
    returns table(clienteid integer, consignatarioid integer, consignatarioactivo bool, consignatarionombre varchar, consignatariofechacreacion timestamptz, consignatariofechamodificacion timestamptz)
    as $$
begin
return query
    select c.clienteid, c.consignatarioid, c.consignatarioactivo, c.consignatarionombre, c.consignatariofechacreacion, c.consignatariofechamodificacion
    from consignatario c order by consignatariofechamodificacion desc limit 5;
end;
$$ language plpgsql;

> Crear SP para agregar (Ambas tablas)
create or replace function insertclientes(c_clienteactivo varchar, c_clientenombre varchar,
    c_clientefechacreacion timestamptz, c_clientefechamodificacion timestamptz)
returns varchar
as $$
declare
resp varchar;
begin
insert into cliente(clienteactivo, clientenombre, clientefechacreacion, clientefechamodificacion)
values (boolin(textout(c_clienteactivo::varchar)), c_clientenombre, c_clientefechacreacion, c_clientefechamodificacion);
resp='se almaceno correctamente';
return resp;
end;
$$ language plpgsql;
select * from selectclientes();
select * from insertclientes('yes','nombre test1', CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);

create or replace function insertconsignatario(c_clienteid integer, c_consignatarioid integer, c_consignatarioactivo varchar, c_consignatarionombre varchar,
       c_consignatariofechacreacion timestamptz, c_consignatariofechamodificacion timestamptz)
    returns varchar
as $$
declare
resp varchar;
begin
insert into consignatario
values (c_clienteid, c_consignatarioid,boolin(textout(c_consignatarioactivo::varchar)), c_consignatarionombre,
        c_consignatariofechacreacion, c_consignatariofechamodificacion);
resp='se almaceno correctamente en consignatario';
return resp;
end;
$$ language plpgsql;
select * from selectconsignatario();
select * from insertconsignatario(7,1,'yes','nombre test', CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);

> Crear SP para actualizar (Ambas tablas)
create or replace function actualizaclientes(c_clienteid integer, c_clienteactivo varchar, c_clientenombre varchar
       ,c_clientefechamodificacion timestamptz)
    returns varchar
as $$
declare
resp varchar;
begin
update cliente
set clienteactivo = boolin(textout(c_clienteactivo::varchar)), clientenombre = c_clientenombre,
    clientefechamodificacion = c_clientefechamodificacion where clienteid = c_clienteid;
resp='se actualizo correctamente';
return resp;
end;
$$ language plpgsql;
select * from selectclientes();
select * from actualizaclientes(7,'no','nombre testup',CURRENT_TIMESTAMP);

create or replace function actualizaconsignatario(c_clienteid integer, c_consignatarioid integer, c_consignatarioactivo varchar, c_consignatarionombre varchar,
        c_consignatariofechamodificacion timestamptz)
    returns varchar
as $$
declare
resp varchar;
begin
update consignatario
set consignatarioactivo = boolin(textout(c_consignatarioactivo::varchar)), consignatarionombre = c_consignatarionombre,
    consignatariofechamodificacion = c_consignatariofechamodificacion where consignatarioid = c_consignatarioid and clienteid = c_clienteid;
resp='se actualizo correctamente en consignatario';
return resp;
end;
$$ language plpgsql;
select * from selectconsignatario();
select * from actualizaconsignatario(8,1,'no','nombre test',CURRENT_TIMESTAMP);

