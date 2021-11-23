use bdhoteles;

create table observaciones (
	codHotel char(6),
    numHabitacion char(4),
    primary key (codHotel, numHabitacion),
    foreign key (codHotel, numHabitacion) references habitaciones(codHotel,numHabitacion),
    observaciones varchar(200)
);